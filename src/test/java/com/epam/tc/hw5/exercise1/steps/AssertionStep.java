package com.epam.tc.hw5.exercise1.steps;

import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;

public class AssertionStep extends AbstractStep{
    private int timecodeLengthToRemove = 9;
    private List<WebElement> logElements = null;

    @Then("There are correct log rows for marked checkboxes")
    public void verifyingLogRows() {

        List<String> logRecords = new ArrayList<>();
        logElements = differentElementsPage.getLogRecords();

        for (int i = 0; i < LOG_ROW_VALUES.size(); i++) {
            logRecords.add(logElements.get(i).getText().substring(timecodeLengthToRemove));
        }

        Assertions.assertThat(logRecords).containsExactlyInAnyOrderElementsOf(LOG_ROW_VALUES);
    }

    @Then("There is correct log row for marked radiobutton")
    public void verifyingRadiobuttonLogRow() {
        List<String> logRecords = new ArrayList<>();
        logElements = differentElementsPage.getLogRecords();

        for (int i = 0; i < RADIOBUTTON_LOG_VALUES.size(); i++) {
            logRecords.add(logElements.get(i).getText().substring(timecodeLengthToRemove));
        }

        Assertions.assertThat(logRecords).containsExactlyInAnyOrderElementsOf(RADIOBUTTON_LOG_VALUES);
    }

    @Then("There is correct log row for chosen color in dropdown list")
    public void verifyingColorLogRows() {
        List<String> logRecords = new ArrayList<>();
        logElements = differentElementsPage.getLogRecords();

        for (int i = 0; i < COLORS_LOG_VALUES.size(); i++) {
            logRecords.add(logElements.get(i).getText().substring(timecodeLengthToRemove));
        }

        Assertions.assertThat(logRecords).containsExactlyInAnyOrderElementsOf(COLORS_LOG_VALUES);
    }
}
