package com.epam.tc.hw4.exercise2;

import com.epam.tc.hw4.Hw4TestsBaseClass;
import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.MainPageObject;
import com.epam.tc.hw4.utils.TestUtils;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExerciseTwoTests extends Hw4TestsBaseClass {

    @Test (dataProvider = "ExerciseTwoValues", dataProviderClass = ValuesForExerciseTwo.class)
    public void ex2Test(List<String> checkboxLogTestValues, List<String> radiobuttonTestValues,
                        List<String> dropdownTestElements) {
        SoftAssertions softAssertions = new SoftAssertions();

        MainPageObject mainPageObject = new MainPageObject(webDriver);

        mainPageObject.login(TestUtils.getUsername(), TestUtils.getPass());

        softAssertions.assertThat(mainPageObject.getLoggedInUsername()).isEqualTo(TestUtils.getLoggedInUsername());

        // Open through the header menu Service -> Different Elements Page
        mainPageObject.getHeaderMenu().clickServiceHeaderMenuButton();
        mainPageObject.getHeaderMenu().clickDifferentElementsMenuButton();
        DifferentElementsPage differentElementsPage = mainPageObject.switchToDifferentElementsPage();
        softAssertions.assertThat("https://jdi-testing.github.io/jdi-light/different-elements.html")
                  .isEqualTo(mainPageObject.getCurrentURL());

        // Select checkboxes water, wind
        differentElementsPage.selectWindCheckbox();
        differentElementsPage.selectWaterCheckbox();

        // Select radio Selen
        differentElementsPage.selectSelenRadiobutton();

        // Select in dropdown Yellow
        differentElementsPage.selectYellowColorInDropdownList();

        //*Assert that:
        //•for each checkbox there is an individual log row and value is corresponded to the status of checkbox*//*
        List<WebElement> logElements = differentElementsPage.getLogRecords();
        differentElementsPage.clickAllCheckboxButtons();
        List<String> logTexts = new ArrayList<>();
        int timecodeLengthToRemove = 9;

        for (int i = 0; i < checkboxLogTestValues.size(); i++) {
            logTexts.add(logElements.get(i).getText().substring(timecodeLengthToRemove));
        }

        softAssertions.assertThat(checkboxLogTestValues).hasSameElementsAs(logTexts);

        //•for radio button there is a log row and value is corresponded to the status of radio button
        differentElementsPage.clickAllRadiobuttons();

        logElements = differentElementsPage.getLogRecords();
        logTexts = new ArrayList<>();

        for (int i = 0; i < radiobuttonTestValues.size(); i++) {
            logTexts.add(logElements.get(i).getText().substring(timecodeLengthToRemove));
        }

        softAssertions.assertThat(radiobuttonTestValues).hasSameElementsAs(logTexts);

        // •for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPage.clickAllDropdownColorsElements();

        logElements = differentElementsPage.getLogRecords();
        logTexts = new ArrayList<>();

        for (int i = 0; i < dropdownTestElements.size(); i++) {
            logTexts.add(logElements.get(i).getText().substring(timecodeLengthToRemove));
        }

        softAssertions.assertThat(dropdownTestElements).hasSameElementsAs(logTexts);

        softAssertions.assertAll();
    }
}
