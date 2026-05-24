package com.dacresillvaant.appium.dataproviders;

import org.testng.annotations.DataProvider;

public class TestData {

    public record LoginData(String username, String password) {}

    @DataProvider
    public Object[][] loginDataProvider() {
        return new Object[][] {
                { new LoginData("admin", "admin") },
                { new LoginData("user", "user") },
                { new LoginData("guest", "guest") },
        };
    }
}