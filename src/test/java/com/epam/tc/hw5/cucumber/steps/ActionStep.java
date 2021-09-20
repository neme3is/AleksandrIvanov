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

    @When("I click on 'Service' button in Header")
    public void clickHeaderServiceButton() {
        headerMenuPageObject.clickServiceHeaderMenuButton();
    }

    @When("I click on 'User Table' button in Service dropdown")
    public void clickUserTableInDropdown() {
        headerMenuPageObject.clickUserTableDropdownButton();
    }

    @When("I select 'vip' checkbox for 'Sergey Ivan'")
    public void clickVipCheckbox() {
        userTablePageObject.clickSergeyIvanVipCheckbox();
    }
}
