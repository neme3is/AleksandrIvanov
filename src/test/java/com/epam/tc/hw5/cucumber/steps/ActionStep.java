package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.cucumber.context.TestContext;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;

public class ActionStep extends AbstractStep {

    @When("I select Water and Wind checkboxes")
    public void selectCheckboxes(String a, String b) {
        differentElementsPage.selectWindCheckbox();
        differentElementsPage.selectWaterCheckbox();

        List<String> checkboxes = new ArrayList<>();

        checkboxes.add(a);
        checkboxes.add(b);

        TestContext.getInstance().addTestObject("diff_el_page_checkboxes", checkboxes);
    }

    @When("I select Selen radiobutton")
    public void selectSelenRadiobutton(String a) {
        differentElementsPage.selectSelenRadiobutton();

        TestContext.getInstance().addTestObject("diff_el_page_radiobutton", a);
    }

    @When("I select Yellow color in dropdown list")
    public void selectYellowColorInDropdownList(String a) {
        differentElementsPage.selectYellowColorInDropdownList();

        TestContext.getInstance().addTestObject("dropdownList_element", a);
    }
}
