package com.dacresillvaant.appium.tests;

import com.dacresillvaant.appium.listeners.TestListener;
import com.dacresillvaant.appium.pages.ProductCatalogPage;
import com.dacresillvaant.appium.pages.ProductDetailPage;
import com.dacresillvaant.appium.retryanalyzer.RetryAnalyzer;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Epic("Mobile Android Tests")
@Feature("Product Detail Tests")
@Listeners(TestListener.class)
public class ProductDetailTests extends BaseTest {

    private ProductCatalogPage productCatalogPage;
    private ProductDetailPage productDetailPage;

    @BeforeMethod
    public void setUpPages() {
        productCatalogPage = new ProductCatalogPage(getDriver());
        productDetailPage = new ProductDetailPage(getDriver());
    }

    @Story("Product detail page opens correctly")
    @Test(testName = "Should open product detail page when tapping a product", retryAnalyzer = RetryAnalyzer.class)
    public void testProductDetailPageOpens() {
//      when
        productCatalogPage.openProductByIndex(0);

//      expect
        Assert.assertFalse(productDetailPage.getProductTitle().isEmpty(),"Product title should be visible on detail page");
    }

    @Story("Product title is displayed")
    @Test(testName = "Should display non-empty product title", retryAnalyzer = RetryAnalyzer.class)
    public void testProductTitleIsNotEmpty() {
//      when
        productCatalogPage.openProductByIndex(0);

//      expect
        Assert.assertFalse(productDetailPage.getProductTitle().isEmpty(), "Product title should not be empty");
    }

    @Story("Product price is displayed")
    @Test(testName = "Should display non-empty product price", retryAnalyzer = RetryAnalyzer.class)
    public void testProductPriceIsNotEmpty() {
//      when
        productCatalogPage.openProductByIndex(0);

//      expect
        Assert.assertFalse(productDetailPage.getProductPrice().isEmpty(), "Product price should not be empty");
    }

    @Story("Product image is displayed")
    @Test(testName = "Should display product image", retryAnalyzer = RetryAnalyzer.class)
    public void testProductImageIsDisplayed() {
//      when
        productCatalogPage.openProductByIndex(0);

//      expect
        Assert.assertTrue(productDetailPage.isProductImageDisplayed(), "Product image should be displayed");
    }

    @Story("Product color picker is displayed")
    @Test(testName = "Should display color picker", retryAnalyzer = RetryAnalyzer.class)
    public void testColorPickerIsDisplayed() {
//      when
        productCatalogPage.openProductByIndex(0);

//      expect
        Assert.assertTrue(productDetailPage.isColorPickerDisplayed(), "Color picker should be displayed");
    }

    @Story("Add to cart button is displayed")
    @Test(testName = "Should display add to cart button", retryAnalyzer = RetryAnalyzer.class)
    public void testAddToCartButtonIsDisplayed() {
//      when
        productCatalogPage.openProductByIndex(0);

//      expect
        Assert.assertTrue(productDetailPage.isAddToCartButtonDisplayed(),"Add to cart button should be displayed");
    }

    @Story("Product description is displayed")
    @Test(testName = "Should display product description", retryAnalyzer = RetryAnalyzer.class)
    public void testProductDescriptionIsDisplayed() {
//      when
        productCatalogPage.openProductByIndex(0);

//      expect
        Assert.assertTrue(productDetailPage.isProductDescriptionDisplayed(), "Product description should be displayed");
    }

    @Story("Default quantity is 1")
    @Test(testName = "Should have default quantity of 1", retryAnalyzer = RetryAnalyzer.class)
    public void testDefaultQuantityIsOne() {
//      when
        productCatalogPage.openProductByIndex(0);

//      expect
        Assert.assertEquals(productDetailPage.getQuantity(), "1","Default quantity should be 1");
    }

    @Story("Increase quantity with plus button")
    @Test(testName = "Should increase quantity when plus button is tapped", retryAnalyzer = RetryAnalyzer.class)
    public void testQuantityIncreasesWhenPlusTapped() {
//      when
        productCatalogPage.openProductByIndex(0);
        productDetailPage.increaseQuantity();

//      expect
        Assert.assertEquals(productDetailPage.getQuantity(), "2","Quantity should be 2 after tapping plus");
    }

    @Story("Decrease quantity with minus button")
    @Test(testName = "Should decrease quantity when minus button is tapped", retryAnalyzer = RetryAnalyzer.class)
    public void testQuantityDecreasesWhenMinusTapped() {
//      when
        productCatalogPage.openProductByIndex(0);
        productDetailPage.increaseQuantity();
        productDetailPage.decreaseQuantity();

//      expect
        Assert.assertEquals(productDetailPage.getQuantity(), "1", "Quantity should be 1 after increasing then decreasing");
    }

    @Story("Navigate back to catalog")
    @Test(testName = "Should navigate back to catalog when back is pressed", retryAnalyzer = RetryAnalyzer.class)
    public void testNavigateBackReturnsToCatalog() {
//      when
        productCatalogPage.openProductByIndex(0);
        productDetailPage.goBack();

//      expect
        Assert.assertTrue(productCatalogPage.isProductListDisplayed(),"Product catalog should be visible after navigating back");
    }
}