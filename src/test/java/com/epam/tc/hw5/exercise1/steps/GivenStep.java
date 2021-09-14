package com.epam.tc.hw5.exercise1.steps;

import com.epam.tc.hw3.utils.TestUtils;
import io.cucumber.java.en.Given;

public class GivenStep extends AbstractStep{
    @Given("I open jdi-testing.com index page")
    public void openJdiHomePage() {

    }

    @Given("I login the site")
    public void loginSite(){
        mainPageObject.login(TestUtils.getUsername(), TestUtils.getPass());
    }

    @Given("I open through the header menu Service -> Different Elements Page")
    public void openSubcategoryInHeaderMenu(String category, String subcategory) {
        mainPageObject.getHeaderMenu().clickDifferentElementsMenuButton();
    }
}
