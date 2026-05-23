package com.dacresillvaant.appium.pages;

import com.dacresillvaant.appium.utils.WaitUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class MenuPage extends BasePage {

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
        return isDisplayed(logOutMenuItem);
    }

    public void openHamburgerMenu() {
        WaitUtils.waitForClickability(driver, hamburgerMenu, 3000).click();
    }

    public void goToLoginPage() {
        openHamburgerMenu();
        WaitUtils.waitForClickability(driver, logInMenuItem, 3000).click();
    }
}