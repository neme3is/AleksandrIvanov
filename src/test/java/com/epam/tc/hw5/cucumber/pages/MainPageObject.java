package com.epam.tc.hw5.cucumber.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageObject extends BasePage {
    private HeaderMenuPageObject headerMenu;
    private LeftSideMenuPageObject leftSideMenu;

    public MainPageObject(WebDriver driver) {
        super(driver);
        headerMenu = new HeaderMenuPageObject(driver);
        leftSideMenu = new LeftSideMenuPageObject(driver);
    }

    @FindBy (id = "user-icon")
    private WebElement userIcon;

    @FindBy (id = "name")
    private WebElement username;

    @FindBy (id = "password")
    private WebElement password;

    @FindBy (id = "login-button")
    private WebElement loginButton;

    @FindBy (className = "benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy (className = "benefit-txt")
    private List<WebElement> benefitTexts;

    @FindBy (id = "frame")
    private WebElement frameWithFrameButton;

    @FindBy (xpath = "//input[@value='Frame Button']")
    private WebElement frameButton;

    @FindBy (className = "dropdown-toggle")
    private WebElement dropdownMenuServiceButton;

    @FindBy (css = ".m-l8 a[href='different-elements.html']")
    private WebElement differentElementsPageLink;

    @FindBy (id = "user-name")
    private WebElement loggedInUsername;

    public void login(String username, String password) {
        userIcon.click();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }

    public List<String> getBenefitTexts() {
        List<String> benefitTextsString = new ArrayList<>();
        for (WebElement i : benefitTexts) {
            benefitTextsString.add(i.getText().replaceAll("\n", " "));
        }
        return benefitTextsString;
    }

    public WebElement getIframeWithFrameButton() {
        return frameWithFrameButton;
    }

    public HeaderMenuPageObject getHeaderMenu() {
        return headerMenu;
    }

    public LeftSideMenuPageObject getLeftSideMenu() {
        return leftSideMenu;
    }

    public WebElement getIframeButton() {
        return frameButton;
    }

    public List<WebElement> getBenefitImages() {
        return benefitIcons;
    }

    public void switchToIframe() {
        driver.switchTo().frame(frameWithFrameButton);
    }

    public void switchToDefaultWindow() {
        driver.switchTo().defaultContent();
    }

    public String getLoggedInUsername() {
        return loggedInUsername.getText();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public DifferentElementsPage switchToDifferentElementsPage() {
        dropdownMenuServiceButton.click();
        differentElementsPageLink.click();
        return new DifferentElementsPage(driver);
    }

    public void open() {
        open("");
    }

}
