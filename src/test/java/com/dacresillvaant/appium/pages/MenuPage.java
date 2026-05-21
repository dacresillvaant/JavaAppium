package com.dacresillvaant.appium.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {

    @AndroidFindBy(accessibility = "View menu")
    private WebElement hamburgerMenu;

    @AndroidFindBy(accessibility = "Login Menu Item")
    private WebElement loginMenuItem;

    public MenuPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void openHamburgerMenu() {
        hamburgerMenu.click();
    }

    public void goToLoginPage() {
        openHamburgerMenu();
        loginMenuItem.click();
    }
}