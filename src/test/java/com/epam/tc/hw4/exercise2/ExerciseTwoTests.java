package com.epam.tc.hw4.exercise2;

import com.epam.tc.hw4.Hw4TestsBaseClass;
import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.MainPageObject;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.List;
import org.testng.annotations.Test;

public class ExerciseTwoTests extends Hw4TestsBaseClass {

    @Feature("Verifying correctness of displayed elements and functionality on different elements page")
    @Story("Logging in and clicking different elements")
    @Test (dataProvider = "ExerciseTwoValues", dataProviderClass = ValuesForExerciseTwo.class)
    public void ex2Test(List<String> checkboxLogTestValues, List<String> radiobuttonTestValues,
                        List<String> dropdownTestElements) {
        MainPageObject mainPageObject = new MainPageObject(webDriver);

        // Log In
        ExerciseTwoTestSteps.login(mainPageObject);

        // Open through the header menu Service -> Different Elements Page
        DifferentElementsPage differentElementsPage = ExerciseTwoTestSteps.openDifferentElementsPage(mainPageObject);

        // Select checkboxes water, wind
        ExerciseTwoTestSteps.selectWaterAndWindCheckboxes(differentElementsPage);

        // Select radio Selen
        ExerciseTwoTestSteps.selectSelenRadio(differentElementsPage);

        // Select in dropdown Yellow
        ExerciseTwoTestSteps.selectYellowInDropdown(differentElementsPage);

        //*Assert that:
        //•for each checkbox there is an individual log row and value is corresponded to the status of checkbox*//*
        ExerciseTwoTestSteps.checkboxStatusInLogs(differentElementsPage, checkboxLogTestValues);

        //•for radio button there is a log row and value is corresponded to the status of radio button
        ExerciseTwoTestSteps.radiobuttonStatusInLogs(differentElementsPage, radiobuttonTestValues);

        // •for dropdown there is a log row and value is corresponded to the selected value.
        ExerciseTwoTestSteps.verifyIndividualLogRowForDropdownValues(differentElementsPage, dropdownTestElements);
    }
}
