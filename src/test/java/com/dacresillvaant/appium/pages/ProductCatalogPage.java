package com.dacresillvaant.appium.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductCatalogPage extends BasePage {

    @AndroidFindBy(accessibility = "title")
    private WebElement productsLabel;

    @AndroidFindBy(accessibility = "Product Title")
    private List<WebElement> productNames;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/priceTV")
    private List<WebElement> productPrices;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productIV")
    private List<WebElement> productImages;

    public ProductCatalogPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isProductListDisplayed() {
        return isDisplayed(productsLabel);
    }

    public int getProductCount() {
        return productNames.size();
    }

    public List<String> getProductNames() {
        return productNames.stream()
                .map(WebElement::getText)
                .toList();
    }

    public List<String> getProductPrices() {
        return productPrices.stream()
                .map(WebElement::getText)
                .toList();
    }
}