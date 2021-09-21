package com.epam.tc.hw6.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftSideMenuPageObject extends BasePage {

    public LeftSideMenuPageObject(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = ".left > li > a > span")
    private List<WebElement> leftSidebarMenuElements;

    public List<WebElement> getLeftSidebarMenuElements() {
        return leftSidebarMenuElements;
    }

    public List<String> getLeftSidebarMenuTexts() {
        List<String> leftSidebarMenuTexts = new ArrayList<>();
        for (WebElement i : leftSidebarMenuElements) {
            leftSidebarMenuTexts.add(i.getText().replaceAll("\n", " "));
        }
        return leftSidebarMenuTexts;
    }
}
