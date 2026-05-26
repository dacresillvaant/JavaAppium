package com.dacresillvaant.appium.listeners;

import com.dacresillvaant.appium.utils.ScreenshotUtils;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Slf4j
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("Starting test: {}", iTestResult.getName());
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info("Test failure: {}", iTestResult.getName());
        ScreenshotUtils.takeScreenShot(iTestResult.getName());
    }
}