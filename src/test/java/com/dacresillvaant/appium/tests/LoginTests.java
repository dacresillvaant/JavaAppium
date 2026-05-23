package com.dacresillvaant.appium.tests;

import com.dacresillvaant.appium.pages.LoginPage;
import com.dacresillvaant.appium.pages.MenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(testName = "Should successfully log in and check that 'Log out' menu item is visible")
    public void testSuccessfulLogin() {
//      given
        MenuPage menuPage = new MenuPage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

//      when
        menuPage.goToLoginPage();
        loginPage.login("admin", "admin");
        menuPage.openHamburgerMenu();

//      expect
        Assert.assertTrue(menuPage.isLogOutMenuItemDisplayed(), "Logout menu item should be visible after successful login");
    }
}