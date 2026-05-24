package com.dacresillvaant.appium.tests;

import com.dacresillvaant.appium.dataproviders.TestData;
import com.dacresillvaant.appium.pages.DialogPage;
import com.dacresillvaant.appium.pages.LoginPage;
import com.dacresillvaant.appium.pages.MenuPage;
import com.dacresillvaant.appium.retryanalyzer.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTests extends BaseTest {

    private MenuPage menuPage;
    private LoginPage loginPage;
    private DialogPage dialogPage;

    @BeforeMethod
    public void setUpPages() {
        menuPage = new MenuPage(getDriver());
        loginPage = new LoginPage(getDriver());
        dialogPage = new DialogPage(getDriver());
    }

    @Test(testName = "Should successfully log in and check that 'Log out' menu item is visible",
            dataProviderClass = TestData.class, dataProvider = "loginDataProvider", retryAnalyzer = RetryAnalyzer.class)
    public void testSuccessfulLogin(TestData.LoginData loginData) {
//      when
        menuPage.goToLoginPage();
        loginPage.login(loginData.username(), loginData.password());
        menuPage.openHamburgerMenu();

//      expect
        Assert.assertTrue(menuPage.isLogOutMenuItemDisplayed(), "Logout menu item should be visible after successful login");
    }

    @Test(testName = "Should return 'Sorry this user has been locked out.' for locked out username", retryAnalyzer = RetryAnalyzer.class)
    public void testLockedUsernameLogin() {
//      given
        String lockedUsername = "alice@example.com";
        String password = "password";

//      when
        menuPage.goToLoginPage();
        loginPage.login(lockedUsername, password);

//      expect
        Assert.assertEquals(loginPage.getPasswordErrorLabel(), "Sorry this user has been locked out.", "Error message mismatch");
    }

    @Test(testName = "Should check username and password fields validation message", retryAnalyzer = RetryAnalyzer.class)
    public void testUsernameAndPasswordFieldsValidation() {
//      given
        SoftAssert softAssert = new SoftAssert();

        String usernameErrorLabel;
        String passwordErrorLabel;

//      when
        menuPage.goToLoginPage();
        loginPage.tapLoginButton();
        usernameErrorLabel = loginPage.getUsernameErrorLabel();

//      and
        loginPage.enterUsername("admin");
        loginPage.tapLoginButton();
        passwordErrorLabel = loginPage.getPasswordErrorLabel();

//      expect
        softAssert.assertEquals(usernameErrorLabel, "Username is required", "Username error message mismatch");
        softAssert.assertEquals(passwordErrorLabel, "Enter Password", "Password error message mismatch");
        softAssert.assertAll();
    }

    @Test(testName = "Should successfully log out and check that 'Log in' menu item is visible", retryAnalyzer = RetryAnalyzer.class)
    public void testSuccessfulLogOut() {
//      when
        menuPage.goToLoginPage();
        loginPage.login("admin", "admin");
        menuPage.openHamburgerMenu();
        menuPage.tapLogOut();
        dialogPage.tapPositiveButton();
        menuPage.openHamburgerMenu();

//      expect
        Assert.assertTrue(menuPage.isLogInMenuItemDisplayed(), "Log In menu item should be visible after successful log out");
    }
}