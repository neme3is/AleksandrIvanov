package com.epam.tc.hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        driver = webDriver;
        wait = new WebDriverWait(webDriver, 10);
    }
}
