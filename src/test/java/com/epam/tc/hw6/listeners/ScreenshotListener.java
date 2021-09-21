package com.epam.tc.hw6.listeners;

import com.epam.tc.hw6.utils.AttachmentUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        ITestContext itc = result.getTestContext();
        Object driver = itc.getAttribute("WebDriver");

        if (driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            AttachmentUtils.makeScreenshotAttachment("Screenshot on failure", screenshot);
        }
    }
}
