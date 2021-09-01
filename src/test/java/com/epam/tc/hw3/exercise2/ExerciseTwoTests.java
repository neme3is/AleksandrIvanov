package com.epam.tc.hw3.exercise2;

import com.epam.tc.hw3.Hw3TestsBaseClass;
import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.MainPageObject;
import com.epam.tc.hw3.utils.TestUtils;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExerciseTwoTests extends Hw3TestsBaseClass {

    @Test
    public void ex2Test() {
        SoftAssertions softAssertions = new SoftAssertions();

        MainPageObject mainPageObject = new MainPageObject(webDriver);

        mainPageObject.login(TestUtils.getUsername(), TestUtils.getPass());

        softAssertions.assertThat(mainPageObject.getLoggedInUsername()).isEqualTo("ROMAN IOVLEV");

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
        for (int i = 0; i < CHECKBOX_LOG_TEST_VALUES.size(); i++) {
            softAssertions.assertThat(logElements.get(i).getText().contains(CHECKBOX_LOG_TEST_VALUES.get(i))).isTrue();
        }

        //•for radio button there is a log row and value is corresponded to the status of radio button

        differentElementsPage.clickAllRadiobuttons();
        logElements = differentElementsPage.getLogRecords();
        for (int i = 0; i < RADIOBUTTON_TEST_VALUES.size(); i++) {
            softAssertions.assertThat(logElements
                .get(i)
                .getText()
                .contains(RADIOBUTTON_TEST_VALUES.get(i))).isTrue();
        }

        // •for dropdown there is a log row and value is corresponded to the selected value.
        differentElementsPage.clickAllDropdownColorsElements();
        logElements = differentElementsPage.getLogRecords();
        for (int i = 0; i < DROPDOWN_TEST_ELEMENTS.size(); i++) {
            softAssertions.assertThat(logElements.get(i).getText().contains(DROPDOWN_TEST_ELEMENTS.get(i)))
                          .isTrue();
        }

        softAssertions.assertAll();
    }
}
