package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.cucumber.pages.DifferentElementsPage;
import com.epam.tc.hw5.cucumber.pages.HeaderMenuPageObject;
import com.epam.tc.hw5.cucumber.pages.LeftSideMenuPageObject;
import com.epam.tc.hw5.cucumber.pages.MainPageObject;
import com.epam.tc.hw5.cucumber.context.TestContext;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class AbstractStep {

    protected MainPageObject mainPageObject;
    protected DifferentElementsPage differentElementsPage;
    protected HeaderMenuPageObject headerMenuPageObject;
    protected LeftSideMenuPageObject leftSideMenuPageObject;
    protected final List<String> LOG_ROW_VALUES = List.of("Fire: condition changed to true",
            "Wind: condition changed to false",
            "Earth: condition changed to true", "Water: condition changed to false");
    protected final List<String> RADIOBUTTON_LOG_VALUES = List.of("metal: value changed to Selen",
        "metal: value changed to Bronze",
        "metal: value changed to Silver", "metal: value changed to Gold");
    protected final List<String> COLORS_LOG_VALUES = List.of("Colors: value changed to Yellow",
        "Colors: value changed to Blue",
        "Colors: value changed to Green", "Colors: value changed to Red");

    public AbstractStep() {
        WebDriver driver = TestContext.getInstance().getTestObject("web_driver");
        mainPageObject = new MainPageObject(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        headerMenuPageObject = new HeaderMenuPageObject(driver);
        leftSideMenuPageObject = new LeftSideMenuPageObject(driver);
    }

}
