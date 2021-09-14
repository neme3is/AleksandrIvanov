package com.epam.tc.hw5.exercise1.steps;

import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.HeaderMenuPageObject;
import com.epam.tc.hw3.pages.LeftSideMenuPageObject;
import com.epam.tc.hw3.pages.MainPageObject;
import com.epam.tc.hw5.exercise1.context.TestContext;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class AbstractStep {

    protected MainPageObject mainPageObject;
    protected DifferentElementsPage differentElementsPage;
    protected HeaderMenuPageObject headerMenuPageObject;
    protected LeftSideMenuPageObject leftSideMenuPageObject;
    protected final List<String> logRowValues = List.of("Fire: condition changed to true",
            "Wind: condition changed to false",
            "Earth: condition changed to true", "Water: condition changed to false");

    public AbstractStep() {
        WebDriver driver = TestContext.getInstance().getTestObject("web_driver");
        mainPageObject = new MainPageObject(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        headerMenuPageObject = new HeaderMenuPageObject(driver);
        leftSideMenuPageObject = new LeftSideMenuPageObject(driver);
    }

}
