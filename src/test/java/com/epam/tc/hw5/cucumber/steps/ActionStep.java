package com.epam.tc.hw5.cucumber.steps;

import io.cucumber.java.en.When;

public class ActionStep extends AbstractStep {

    @When("I select Water and Wind checkboxes")
    public void selectCheckboxes() {
        differentElementsPage.selectWindCheckbox();
        differentElementsPage.selectWaterCheckbox();

    }

    @When("I select Selen radiobutton")
    public void selectSelenRadiobutton() {
        differentElementsPage.selectSelenRadiobutton();
    }

    @When("I select Yellow color in dropdown list")
    public void selectYellowColorInDropdownList() {
        differentElementsPage.selectYellowColorInDropdownList();
    }
}
