package com.epam.tc.hw5.exercise1.steps;

import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

public class AssertionStep extends AbstractStep{

    @Then("There are correct log rows for marked checkboxes")
    public void verifyingLogRows() {
        Assertions.assertThat()
    }
}
