package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Hw2TestsBaseClass {
    protected WebDriver webDriver;

    @BeforeClass (alwaysRun = true)
    public void beforeTestMethod() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts()
                 .implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void afterTestMethod() {
        webDriver.quit();
    }
}
