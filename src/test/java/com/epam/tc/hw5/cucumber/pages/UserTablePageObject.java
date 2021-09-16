package com.epam.tc.hw5.cucumber.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePageObject extends BasePage{
    private HeaderMenuPageObject headerMenu;
    private LeftSideMenuPageObject leftSideMenu;

    public UserTablePageObject(WebDriver webDriver) {
        super(webDriver);
        headerMenu = new HeaderMenuPageObject(driver);
        leftSideMenu = new LeftSideMenuPageObject(driver);
    }

    @FindBy(tagName = "select")
    private List<WebElement> dropdownNumberTypes;

    public List<WebElement> getDropdownNumberTypesList() {
        return dropdownNumberTypes;
    }

}
