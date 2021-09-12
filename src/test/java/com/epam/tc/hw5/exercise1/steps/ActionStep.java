package com.epam.tc.hw5.exercise1.steps;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.When;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ActionStep extends AbstractStep {

    @ParameterType("'(.+)'")
    public List<String> checkboxValues(String checkboxes) {
        return Arrays.stream(checkboxes.split(","))
                     .collect(Collectors.toList());
    }
    @When("I select {checkboxValues} checkboxes")
    public void selectCheckboxes(List<String> checkboxValues) {

    }
}
