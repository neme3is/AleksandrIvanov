package com.epam.tc.hw5.cucumber.pages;

import com.epam.tc.hw5.cucumber.utils.UserTable;
import io.cucumber.java.sl.In;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserTablePageObject extends BasePage{
    private HeaderMenuPageObject headerMenu;
    private LeftSideMenuPageObject leftSideMenu;
    private int elementsInLogToRemove = 9;

    public UserTablePageObject(WebDriver webDriver) {
        super(webDriver);
        headerMenu = new HeaderMenuPageObject(driver);
        leftSideMenu = new LeftSideMenuPageObject(driver);
    }

    @FindBy(tagName = "select")
    private List<WebElement> dropdownNumberTypes;

    @FindBy(css = ".main-content td a")
    private List<WebElement> usernames;

    @FindBy(css = ".main-content td div span")
    private List<WebElement> descriptionTexts;

    @FindBy(css = ".main-content td div input")
    private List<WebElement> checkboxesOnUserTable;

    @FindBy(css = "tbody tr")
    private List<WebElement> userTableRows;

    @FindBy(css = "select option")
    private List<WebElement> dropdownOptions;

    @FindBy(id = "ivan")
    private WebElement sergeyIvanVipCheckbox;

    @FindBy (css = ".logs li:first-child")
    private WebElement lastLogRecord;

    public List<WebElement> getDropdownNumberTypesList() {
        return dropdownNumberTypes;
    }

    public List<WebElement> getUsernames() {
        return usernames;
    }

    public List<WebElement> getDescriptionTexts() {
        return descriptionTexts;
    }

    public List<WebElement> getCheckboxesElementOnUserTable() {
        return checkboxesOnUserTable;
    }

    private List<UserTable> userTableList = new ArrayList<>();

    public List<UserTable> getUserTableRowsList() {
        for (WebElement we : userTableRows) {
            Integer number = Integer.valueOf(we.findElement(By.cssSelector("td")).getText());
            String user = we.findElement((By.cssSelector("td a"))).getText();
            String description = we.findElement(By.cssSelector("td span")).getText().replace("\n", " ");
            userTableList.add(new UserTable(number, user, description));
        }
        return userTableList;
    }

    public Set<String> getDropdownOptions() {
        Set<String> dropdownElements = new HashSet<>();
        for (WebElement we : dropdownOptions) {
            dropdownElements.add(we.getText());
        }
        return dropdownElements;
    }

    public void clickSergeyIvanVipCheckbox() {
        sergeyIvanVipCheckbox.click();
    }

    public String getLastLogRow() {
        return new String(lastLogRecord.getText()).substring(elementsInLogToRemove);
    }

}
