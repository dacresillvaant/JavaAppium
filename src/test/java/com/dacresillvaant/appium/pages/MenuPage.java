package com.dacresillvaant.appium.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MenuPage extends BasePage {

    @AndroidFindBy(accessibility = "View cart")
    private WebElement cartIcon;

    @AndroidFindBy(accessibility = "View menu")
    private WebElement hamburgerMenu;

    @AndroidFindBy(accessibility = "Login Menu Item")
    private WebElement logInMenuItem;

    @AndroidFindBy(accessibility = "Logout Menu Item")
    private WebElement logOutMenuItem;

    public MenuPage(AndroidDriver driver) {
        super(driver);
    }

    public boolean isLogOutMenuItemDisplayed() {
        return isDisplayed(logOutMenuItem, 3000);
    }

    public boolean isLogInMenuItemDisplayed() {
        return isDisplayed(logInMenuItem, 3000);
    }

    public void openCart() {
        tap(cartIcon, 3000);
    }

    public void openHamburgerMenu() {
        tap(hamburgerMenu, 3000);
    }

    public void goToLoginPage() {
        openHamburgerMenu();
        tap(logInMenuItem, 3000);
    }

    public void tapLogOut() {
        tap(logOutMenuItem, 3000);
    }
}