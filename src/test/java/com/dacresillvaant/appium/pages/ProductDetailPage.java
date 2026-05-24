package com.dacresillvaant.appium.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailPage extends BasePage{

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement productTitle;

    @AndroidFindBy(accessibility = "Displays selected product")
    private WebElement productImage;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private WebElement productPrice;

    @AndroidFindBy(accessibility = "Displays available colors of selected product")
    private WebElement colorPicker;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/minusIV")
    private WebElement minusButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private WebElement plusButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement quantityLabel;

    @AndroidFindBy(accessibility = "Tap to add product to cart")
    private WebElement addToCartButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productHeightLightsTV")
    private WebElement productHighlights;

    @Getter
    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/descTV")
    private WebElement productDescription;

    public ProductDetailPage(AndroidDriver driver) {
        super(driver);
    }

    public void goBack(WebDriver driver) {
        navigateBack(driver);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public String getQuantity() {
        return quantityLabel.getText();
    }

    public boolean isProductImageDisplayed() {
        return isDisplayed(productImage);
    }

    public boolean isColorPickerDisplayed() {
        return isDisplayed(colorPicker);
    }

    public boolean isAddToCartButtonDisplayed() {
        return isDisplayed(addToCartButton);
    }

    public boolean isProductDescriptionDisplayed() {
        scrollToBottom(driver, 5);
        return isDisplayed(productDescription);
    }

    public void tapAddToCart() {
        tap(driver, addToCartButton, 3000);
    }

    public void increaseQuantity() {
        tap(driver, plusButton, 3000);
    }

    public void decreaseQuantity() {
        tap(driver, minusButton, 3000);
    }
}
