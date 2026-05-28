package com.dacresillvaant.appium.tests;

import com.dacresillvaant.appium.listeners.TestListener;
import com.dacresillvaant.appium.pages.CartPage;
import com.dacresillvaant.appium.pages.MenuPage;
import com.dacresillvaant.appium.pages.ProductCatalogPage;
import com.dacresillvaant.appium.pages.ProductDetailPage;
import com.dacresillvaant.appium.retryanalyzer.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class CartTests extends BaseTest {

    private ProductCatalogPage productCatalogPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;
    private MenuPage menuPage;

    @BeforeMethod
    public void setUpPages() {
        productCatalogPage = new ProductCatalogPage(getDriver());
        productDetailPage = new ProductDetailPage(getDriver());
        cartPage = new CartPage(getDriver());
        menuPage = new MenuPage(getDriver());
    }

    @Test(testName = "Should display correct product name in cart", retryAnalyzer = RetryAnalyzer.class)
    public void testProductNameInCart() {
//      given
        productCatalogPage.openProductByIndex(0);
        String expectedProductName = productDetailPage.getProductTitle();

//      when
        productDetailPage.tapAddToCart();
        menuPage.openCart();
        String actualProductName = cartPage.getProductName();

//      expect
        Assert.assertEquals(actualProductName, expectedProductName, "Product name is incorrect.");
    }

    @Test(testName = "Should display correct product price in cart", retryAnalyzer = RetryAnalyzer.class)
    public void testProductPriceInCart() {
//      given
        productCatalogPage.openProductByIndex(0);
        String expectedProductPrice = productDetailPage.getProductPrice();

//      when
        productDetailPage.tapAddToCart();
        menuPage.openCart();
        String actualProductPrice = cartPage.getProductPrice();

//      expect
        Assert.assertEquals(expectedProductPrice, actualProductPrice, "Product price is incorrect.");
    }

    @Test(testName = "Should display proceed to checkout button", retryAnalyzer = RetryAnalyzer.class)
    public void testProceedToCheckoutButtonIsDisplayed() {
//      given
        productCatalogPage.openProductByIndex(0);

//      when
        productDetailPage.tapAddToCart();
        menuPage.openCart();
        boolean isProceedToCheckoutButtonDisplayed = cartPage.isProceedToCheckoutButtonDisplayed();

//      expect
        Assert.assertTrue(isProceedToCheckoutButtonDisplayed, "Proceed to checkout button should be displayed.");
    }

    @Test(testName = "Should remove product from cart", retryAnalyzer = RetryAnalyzer.class)
    public void testRemoveProductFromCart() {
//      given
        productCatalogPage.openProductByIndex(0);

//      when
        productDetailPage.tapAddToCart();
        menuPage.openCart();
        cartPage.tapRemoveItem();
        boolean isNoItemsDisplayed = cartPage.isNoItemsDisplayed();

//      expect
        Assert.assertTrue(isNoItemsDisplayed, "No items label should be displayed.");
    }

    @Test(testName = "Should increase product quantity in cart", retryAnalyzer = RetryAnalyzer.class)
    public void testIncreaseQuantityInCart() {
//      given
        productCatalogPage.openProductByIndex(0);

//      when
        productDetailPage.tapAddToCart();
        menuPage.openCart();
        int initialQuantity = Integer.parseInt(cartPage.getQuantity());
        cartPage.tapIncreaseQuantity();
        int increasedQuantity = Integer.parseInt(cartPage.getQuantity());

//      expect
        Assert.assertEquals(increasedQuantity, initialQuantity + 1, "Product quantity should be increased by 1.");
    }

    @Test(testName = "Should decrease product quantity in cart", retryAnalyzer = RetryAnalyzer.class)
    public void testDecreaseQuantityInCart() {
//      given
        productCatalogPage.openProductByIndex(0);

//      when
        productDetailPage.tapAddToCart();
        menuPage.openCart();
        cartPage.tapDecreaseQuantity();
        boolean isNoItemsDisplayed = cartPage.isNoItemsDisplayed();

//      expect
        Assert.assertTrue(isNoItemsDisplayed, "No items label should be displayed after decrease quantity to 0.");
    }
}