package com.dacresillvaant.appium.tests;

import com.dacresillvaant.appium.driver.DriverFactory;
import com.dacresillvaant.appium.pages.LoginPage;
import com.dacresillvaant.appium.pages.MenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void testDriverInitialization() {
        Assert.assertNotNull(DriverFactory.getDriver());
    }

    @Test
    public void testSuccessfulLogin() {
        MenuPage menuPage = new MenuPage(getDriver());
        menuPage.goToLoginPage();

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("admin", "admin");

        menuPage.openHamburgerMenu();
    }
}