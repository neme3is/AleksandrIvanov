package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.cucumber.context.TestContext;
import com.epam.tc.hw5.cucumber.utils.UserTable;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AssertionStep extends AbstractStep {
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
        Assertions.assertThat(((WebDriver) TestContext.getInstance().getTestObject("web_driver")).getCurrentUrl())
                  .isEqualTo("https://jdi-testing.github.io/jdi-light/user-table.html");
    }

    @Then("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void verifyDropdownNumberTypes() {
        Assertions.assertThat(userTablePageObject.getDropdownNumberTypesList()).hasSize(6);
    }

    @Then("6 Usernames should be displayed on Users Table on User Table Page")
    public void verifyNumberOfDisplayedUsernames() {
        Assertions.assertThat(userTablePageObject.getUsernames()).hasSize(6);
        Assertions.assertThat(userTablePageObject.getUsernames()).allMatch(username -> username.isDisplayed());
    }

    @Then("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void verifyNumberOfDescriptionTextsUnderImages() {
        Assertions.assertThat(userTablePageObject.getDescriptionTexts()).hasSize(6);
        Assertions.assertThat(userTablePageObject.getDescriptionTexts()).allMatch(username -> username.isDisplayed());
    }

    @Then("6 checkboxes should be displayed on Users Table on User Table Page")
    public void verifyNumberOfCheckboxes() {
        Assertions.assertThat(userTablePageObject.getCheckboxesElementOnUserTable()).hasSize(6);
        Assertions.assertThat(userTablePageObject.getCheckboxesElementOnUserTable())
                  .allMatch(username -> username.isDisplayed());
    }

    @Then("User table should contain following values:")
    public void verifyUserTableContainsValues(DataTable table) {
        List<Map<String, String>> userTableRows = table.asMaps();

        List<UserTable> ut = new ArrayList<>();

        for (Map<String, String> row : userTableRows) {
            String number = row.get("Number");
            ut.add(new UserTable(Integer.valueOf(number), row.get("User"), row.get("Description")));
        }

        Assertions.assertThat(ut).isEqualTo(userTablePageObject.getUserTableRowsList());
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void verifyDropdownElement(DataTable table) {
        List<Map<String, String>> dropdownExpectedValuesMaps = table.asMaps();
        Set<String> dropdownExpectedValues = new HashSet<>();

        for (Map<String, String> map : dropdownExpectedValuesMaps) {
            dropdownExpectedValues.add(map.get("Dropdown Values"));
        }

        Assertions.assertThat(dropdownExpectedValues).hasSameElementsAs(userTablePageObject.getDropdownOptions());
    }

    @Then("1 log row has 'Vip: condition changed to true' text in the row section")
    public void verifyLogRowForVipCheckbox() {
        Assertions.assertThat("Vip: condition changed to true").isEqualTo(userTablePageObject.getLastLogRow());
    }
}
