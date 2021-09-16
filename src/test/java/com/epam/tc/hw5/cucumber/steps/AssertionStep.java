package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.cucumber.context.TestContext;
import io.cucumber.java.en.Then;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AssertionStep extends AbstractStep{
    private int timecodeLengthToRemove = 9;
    List<String> logElements = new ArrayList<String>();
    {
        differentElementsPage.getLogRecords().stream().forEach(element -> logElements.add(element
            .getText().substring(timecodeLengthToRemove)));

    }

    @Then("There are correct log rows for marked checkboxes")
    public void verifyingLogRows() {
        Assertions.assertThat(logElements).containsAll((TestContext
            .getInstance().getTestObject("checkbox_log")));
    }

    @Then("There is correct log row for marked radiobutton")
    public void verifyingRadiobuttonLogRow() {
        Assertions.assertThat(logElements).containsAll((TestContext
            .getInstance().getTestObject("radiobutton_log")));
    }

    @Then("There is correct log row for chosen color in dropdown list")
    public void verifyingColorLogRows() {
        Assertions.assertThat(logElements).containsAll((TestContext
            .getInstance().getTestObject(("color_log"))));
    }

    @Then("'User Table' page should be opened")
    public void verifyUserTablePageWasOpened() {
        Assertions.assertThat(((WebDriver) TestContext.getInstance().getTestObject("web_driver")).getCurrentUrl()).
            isEqualTo("https://jdi-testing.github.io/jdi-light/user-table.html");
    }

    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void verifyDropdownNumberTypes() {
        Assertions.assertThat(userTablePageObject.getDropdownNumberTypesList()).hasSize(6);
    }
}
