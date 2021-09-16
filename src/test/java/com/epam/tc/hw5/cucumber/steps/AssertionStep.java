package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.cucumber.context.TestContext;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;

public class AssertionStep extends AbstractStep{
    private int timecodeLengthToRemove = 9;
    List<String> logElements = new ArrayList<String>();
    {
        differentElementsPage.getLogRecords().stream().map(element -> logElements.add(element
                .getText().substring(timecodeLengthToRemove)));
    }

    @ParameterType("[a-z]+")
    public List<String> checkboxLogRow(String s) {
        return TestContext.getInstance().getTestObject("checkbox_log");
    }

    @ParameterType("[a-z]+")
    public List<String> radiobuttonLogRow(String s) {
        return TestContext.getInstance().getTestObject("radiobutton_log");
    }

    @ParameterType("[a-z]+")
    public List<String> colorsLogRow(String s) {
        return TestContext.getInstance().getTestObject("color_log");
    }

    @Then("There are correct log rows for marked {checkboxLogRow}")
    public void verifyingLogRows(List<String> checkboxLogRow) {
        Assertions.assertThat(logElements).containsExactlyInAnyOrderElementsOf(checkboxLogRow);
    }

    @Then("There is correct log row for marked {radiobuttonLogRow}")
    public void verifyingRadiobuttonLogRow(List<String> radiobuttonLogRow) {
        Assertions.assertThat(logElements).containsExactlyInAnyOrderElementsOf(radiobuttonLogRow);
    }

    @Then("There is correct log row for chosen {colorsLogRow} in dropdown list")
    public void verifyingColorLogRows(List<String> colorsLogRow) {
        Assertions.assertThat(logElements).containsExactlyInAnyOrderElementsOf(colorsLogRow);
    }
}
