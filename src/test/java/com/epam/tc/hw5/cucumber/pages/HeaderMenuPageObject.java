package com.epam.tc.hw5.cucumber.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuPageObject extends BasePage {

    public HeaderMenuPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".m-l8 > li > a:first-child")
    private List<WebElement> headerMenuElements;

    @FindBy(className = "dropdown-toggle")
    private WebElement serviceHeaderMenuButton;

    @FindBy(css = ".m-l8 a[href='different-elements.html']")
    private WebElement differentElementsPage;

    @FindBy(css = ".m-l8 a[href='user-table.html']")
    private WebElement userTableDropdownButton;

    public List<WebElement> getHeaderMenuElements() {
        return headerMenuElements;
    }

    public boolean verifyElementIsDisplayed(String text) {
        for (WebElement we : headerMenuElements) {
            if (we.getText().equals(text)) {
                return true;
            }
        }
        return false;
    }

    public void clickServiceHeaderMenuButton() {
        serviceHeaderMenuButton.click();
    }

    public void clickDifferentElementsMenuButton() {
        differentElementsPage.click();
    }

    public void clickUserTableDropdownButton() {
        userTableDropdownButton.click();
    }
}
