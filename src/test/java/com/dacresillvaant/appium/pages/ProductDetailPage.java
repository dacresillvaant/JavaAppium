package com.dacresillvaant.appium.pages;

import com.dacresillvaant.appium.utils.WaitUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
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

    public void goBack() {
        navigateBack();
    }

    public String getProductTitle() {
        return WaitUtils.waitForVisibility(driver, productTitle, 3000).getText();
    }

    public String getProductPrice() {
        return WaitUtils.waitForVisibility(driver, productPrice, 3000).getText();
    }

    public String getQuantity() {
        return WaitUtils.waitForVisibility(driver, quantityLabel, 3000).getText();
    }

    public boolean isProductImageDisplayed() {
        return isDisplayed(productImage, 3000);
    }

    public boolean isColorPickerDisplayed() {
        return isDisplayed(colorPicker, 3000);
    }

    public boolean isAddToCartButtonDisplayed() {
        return isDisplayed(addToCartButton, 3000);
    }

    public boolean isProductDescriptionDisplayed() {
        scrollToBottom(5);
        return isDisplayed(productDescription, 3000);
    }

    public void tapAddToCart() {
        tap(addToCartButton, 3000);
    }

    public void increaseQuantity() {
        tap(plusButton, 3000);
    }

    public void decreaseQuantity() {
        tap(minusButton, 3000);
    }
}
