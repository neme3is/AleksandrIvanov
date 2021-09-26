package com.epam.tc.hw6;

import com.epam.tc.hw6.driver.WebDriverSingleton;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Hw6TestsBaseClass {
    public WebDriver webDriver;
    private String baseURL = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeClass (alwaysRun = true)
    public void setupDriver(ITestContext context) {
        webDriver = WebDriverSingleton.getDriver();
        webDriver.manage().timeouts()
                     .implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(baseURL);
        context.setAttribute("WebDriver", webDriver);
    }

    @AfterClass(alwaysRun = true)
    public void afterTestMethod() {
        WebDriverSingleton.closeDriver();
    }
}
