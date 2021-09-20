package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.cucumber.context.TestContext;
import com.epam.tc.hw5.cucumber.pages.DifferentElementsPage;
import com.epam.tc.hw5.cucumber.pages.HeaderMenuPageObject;
import com.epam.tc.hw5.cucumber.pages.LeftSideMenuPageObject;
import com.epam.tc.hw5.cucumber.pages.MainPageObject;
import com.epam.tc.hw5.cucumber.pages.UserTablePageObject;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected MainPageObject mainPageObject;
    protected DifferentElementsPage differentElementsPage;
    protected HeaderMenuPageObject headerMenuPageObject;
    protected LeftSideMenuPageObject leftSideMenuPageObject;
    protected UserTablePageObject userTablePageObject;

    public AbstractStep() {
        WebDriver driver = TestContext.getInstance().getTestObject("web_driver");
        mainPageObject = new MainPageObject(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        headerMenuPageObject = new HeaderMenuPageObject(driver);
        leftSideMenuPageObject = new LeftSideMenuPageObject(driver);
        userTablePageObject = new UserTablePageObject(driver);
    }

}
