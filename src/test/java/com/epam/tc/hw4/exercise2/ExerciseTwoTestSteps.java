package com.epam.tc.hw4.exercise2;

import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.MainPageObject;
import com.epam.tc.hw4.utils.TestUtils;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;

public class ExerciseTwoTestSteps {
    @Step("Логин пользователя")
    public static void login (MainPageObject mainPageObject) {
        mainPageObject.login(TestUtils.getUsername(), TestUtils.getPass());
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public static DifferentElementsPage openDifferentElementsPage(MainPageObject mainPageObject) {
        mainPageObject.getHeaderMenu().clickServiceHeaderMenuButton();
        mainPageObject.getHeaderMenu().clickDifferentElementsMenuButton();
        return mainPageObject.switchToDifferentElementsPage();
    }

    @Step("Select water, wind checkboxes")
    public static void selectWaterAndWindCheckboxes(DifferentElementsPage differentElementsPage) {
        differentElementsPage.selectWindCheckbox();
        differentElementsPage.selectWaterCheckbox();
    }

    @Step("Select Selen radio button")
    public static void selectSelenRadio(DifferentElementsPage differentElementsPage) {
        differentElementsPage.selectSelenRadiobutton();
    }

    @Step("Select in dropdown Yellow")
    public static void selectYellowInDropdown(DifferentElementsPage differentElementsPage) {
        differentElementsPage.selectYellowColorInDropdownList();
    }

    @Step("Assert for each checkbox there is an individual log row and value is corresponded to the status of checkbox")
    public static void checkboxStatusInLogs(DifferentElementsPage differentElementsPage,
                                           List<String> checkboxLogTestValues) {
        List<WebElement> logElements = differentElementsPage.getLogRecords();
        differentElementsPage.clickAllCheckboxButtons();
        List<String> logTexts = new ArrayList<>();
        int timecodeLengthToRemove = 9;

        for (int i = 0; i < checkboxLogTestValues.size(); i++) {
            logTexts.add(logElements.get(i).getText().substring(timecodeLengthToRemove));
        }

        Assertions.assertThat(checkboxLogTestValues).hasSameElementsAs(logTexts);
    }

    @Step("Assert for radio button there is a log row and value is corresponded to the status of radio button")
    public static void radiobuttonStatusInLogs(DifferentElementsPage differentElementsPage,
                                               List<String> radiobuttonTestValues) {
        differentElementsPage.clickAllRadiobuttons();

        List<WebElement> logElements = differentElementsPage.getLogRecords();
        List<String> logTexts = new ArrayList<>();
        int timecodeLengthToRemove = 9;

        for (int i = 0; i < radiobuttonTestValues.size(); i++) {
            logTexts.add(logElements.get(i).getText().substring(timecodeLengthToRemove));
        }

        Assertions.assertThat(radiobuttonTestValues).hasSameElementsAs(logTexts);
    }

    @Step("Assert that for dropdown there is a log row and value is corresponded to the selected value")
    public static void verifyIndividualLogRowForDropdownValues(DifferentElementsPage differentElementsPage,
                                                               List<String> dropdownTestElements) {
        differentElementsPage.clickAllDropdownColorsElements();

        List<WebElement> logElements = differentElementsPage.getLogRecords();
        List<String> logTexts = new ArrayList<>();
        int timecodeLengthToRemove = 9;

        for (int i = 0; i < dropdownTestElements.size(); i++) {
            logTexts.add(logElements.get(i).getText().substring(timecodeLengthToRemove));
        }

        Assertions.assertThat(dropdownTestElements).hasSameElementsAs(logTexts);
    }
}
