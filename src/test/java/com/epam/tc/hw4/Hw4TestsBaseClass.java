package com.epam.tc.hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Hw4TestsBaseClass {
    public static WebDriver webDriver;
    private String baseURL = "https://jdi-testing.github.io/jdi-light/index.html";

    @BeforeClass (alwaysRun = true)
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts()
                     .implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriver.get(baseURL);
    }

    @BeforeClass
    public void setAttribute(ITestContext context){
        context.setAttribute("WebDriver", webDriver);
    }

    @AfterClass(alwaysRun = true)
    public void afterTestMethod() {
        webDriver.quit();
    }
}
