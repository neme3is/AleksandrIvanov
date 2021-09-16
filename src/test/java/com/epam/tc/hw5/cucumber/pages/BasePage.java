package com.epam.tc.hw5.cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private static final String BASE_URL = "https://jdi-testing.github.io";
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        driver = webDriver;
        wait = new WebDriverWait(webDriver, 10);
    }

    protected void open(String url) {
        driver.navigate().to(BASE_URL + url);
    }
}
