package com.dacresillvaant.appium.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/titleTV")
    private WebElement productName;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private WebElement productPrice;

    @AndroidFindBy(accessibility = "Removes product from cart")
    private WebElement removeItemButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noItemTitleTV")
    private WebElement noItemsLabel;

    @AndroidFindBy(accessibility = "Decrease item quantity")
    private WebElement decreaseQuantityButton;

    @AndroidFindBy(accessibility = "Increase item quantity")
    private WebElement increaseQuantityButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement quantityLabel;

    @AndroidFindBy(accessibility = "Confirms products for checkout")
    private WebElement proceedToCheckoutButton;

    public CartPage(AndroidDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return getText(productName, 3000);
    }

    public String getProductPrice() {
        return getText(productPrice, 3000);
    }

    public String getQuantity() {
        return getText(quantityLabel, 3000);
    }

    public boolean isProceedToCheckoutButtonDisplayed() {
        return isDisplayed(proceedToCheckoutButton, 3000);
    }

    public boolean isProductNameDisplayed() {
        return isDisplayed(productName, 3000);
    }

    public boolean isNoItemsDisplayed() {
        return isDisplayed(noItemsLabel, 10000);
    }

    public void tapRemoveItem() {
        tap(removeItemButton, 3000);
    }

    public void tapIncreaseQuantity() {
        tap(increaseQuantityButton, 3000);
    }

    public void tapDecreaseQuantity() {
        tap(decreaseQuantityButton, 3000);
    }

    public void tapProceedToCheckout() {
        tap(proceedToCheckoutButton, 3000);
    }
}