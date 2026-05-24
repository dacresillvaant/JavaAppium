package com.dacresillvaant.appium.tests;

import com.dacresillvaant.appium.pages.ProductCatalogPage;
import com.dacresillvaant.appium.retryanalyzer.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductCatalogTests extends BaseTest {

    private ProductCatalogPage productCatalogPage;

    @BeforeMethod
    public void setUpPages() {
        productCatalogPage = new ProductCatalogPage(getDriver());
    }

    @Test(testName = "Should display product catalog on app launch", retryAnalyzer = RetryAnalyzer.class)
    public void testProductListIsDisplayed() {
//      expect
        Assert.assertTrue(productCatalogPage.isProductListDisplayed(), "Product catalog should be visible on launch");
    }

    @Test(testName = "Should display at least one product", retryAnalyzer = RetryAnalyzer.class)
    public void testProductCountIsGreaterThanZero() {
//      expect
        Assert.assertTrue(productCatalogPage.getProductCount() > 0, "Product count should be greater than 0");
    }

    @Test(testName = "Should display non-empty product names", retryAnalyzer = RetryAnalyzer.class)
    public void testProductNamesAreNotEmpty() {
//      expect
        productCatalogPage.getProductNames()
                .forEach(name -> Assert.assertFalse(name.isEmpty(), "Product name should not be empty"));
    }

    @Test(testName = "Should display non-empty product prices", retryAnalyzer = RetryAnalyzer.class)
    public void testProductPricesAreNotEmpty() {
//      expect
        productCatalogPage.getProductPrices()
                .forEach(price -> Assert.assertFalse(price.isEmpty(), "Product price should not be empty"));
    }
}