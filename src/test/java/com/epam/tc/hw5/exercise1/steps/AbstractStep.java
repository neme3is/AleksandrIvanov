package com.epam.tc.hw5.exercise1.steps;

import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.HeaderMenuPageObject;
import com.epam.tc.hw3.pages.LeftSideMenuPageObject;
import com.epam.tc.hw3.pages.MainPageObject;
import com.epam.tc.hw5.exercise1.context.TestContext;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected MainPageObject jdiMainPage;
    protected DifferentElementsPage differentElementsPage;
    protected HeaderMenuPageObject headerMenuPageObject;
    protected LeftSideMenuPageObject leftSideMenuPageObject;

    public AbstractStep() {
        WebDriver driver = TestContext.getInstance().getTestObject("web_driver");
        jdiMainPage = new MainPageObject(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        headerMenuPageObject = new HeaderMenuPageObject(driver);
        leftSideMenuPageObject = new LeftSideMenuPageObject(driver);
    }

}
