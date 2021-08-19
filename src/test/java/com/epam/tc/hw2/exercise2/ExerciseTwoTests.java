package com.epam.tc.hw2.exercise2;

import com.epam.tc.hw2.Hw2TestsBaseClass;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ExerciseTwoTests extends Hw2TestsBaseClass {

    SoftAssertions softAssert = new SoftAssertions();

    @Test
    public void ex2Test() {
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        softAssert.assertThat("https://jdi-testing.github.io/jdi-light/index.html")
                  .isEqualTo(webDriver.getCurrentUrl());
        softAssert.assertThat("Home Page").isEqualTo(webDriver.getTitle());

        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();

        softAssert.assertThat(webDriver.findElement(By.id("user-name")).getText()).isEqualTo("ROMAN IOVLEV");

        // Open through the header menu Service -> Different Elements Page
        webDriver.findElement(By.className("dropdown-toggle")).click();
        webDriver.findElement(By.cssSelector(".m-l8 a[href='different-elements.html']")).click();
        softAssert.assertThat("https://jdi-testing.github.io/jdi-light/different-elements.html")
                  .isEqualTo(webDriver.getCurrentUrl());

        // Select checkboxes water, wind
        webDriver.findElement(By.xpath("//label[text()[contains(.,'Water')]]/input")).click();
        webDriver.findElement(By.xpath("//label[text()[contains(.,'Wind')]]/input")).click();
        softAssert.assertThat(webDriver.findElement(By.xpath("//label[text()[contains(.,'Water')]]/input"))
                                       .isSelected());
        softAssert.assertThat(webDriver.findElement(By.xpath("//label[text()[contains(.,'Wind')]]/input"))
                                       .isSelected());

        // Select radio Selen
        webDriver.findElement(By.xpath("//label[text()[contains(.,'Selen')]]/input")).click();
        softAssert.assertThat(webDriver.findElement(By.xpath("//label[text()[contains(.,'Selen')]]/input"))
                                       .isSelected());

        // Select in dropdown Yellow
        webDriver.findElement(By.className("colors")).click();
        webDriver.findElement((By.xpath("//select[@class='uui-form-element']/option[text()[contains(.,'Yellow')]]")))
                 .click();

        Select select = new Select(webDriver.findElement(By.cssSelector("select.uui-form-element")));
        String option = select.getFirstSelectedOption().getText();

        softAssert.assertThat(option).isEqualTo("Yellow");

        //*Assert that:
        //•for each checkbox there is an individual log row and value is corresponded to the status of checkbox*//*
        List<WebElement> checkboxElements = webDriver.findElements(By
            .cssSelector(".checkbox-row .label-checkbox input"));

        for (WebElement we : checkboxElements) {
            we.click();
        }

        List<String> checkboxLogTestValues = List.of("Fire: condition changed to true",
            "Wind: condition changed to false",
            "Earth: condition changed to true", "Water: condition changed to false");

        List<WebElement> checkboxLogElements = webDriver.findElements(By
            .cssSelector(".logs li"));

        for (int i = 0; i < checkboxLogTestValues.size(); i++) {
            softAssert.assertThat(checkboxLogElements.get(i).getText().contains(checkboxLogTestValues.get(i)));
        }

        //•for radio button there is a log row and value is corresponded to the status of radio button
        List<WebElement> radiobuttonElements = webDriver.findElements(By
            .cssSelector(".checkbox-row .label-radio input"));

        for (WebElement we : radiobuttonElements) {
            we.click();
        }

        List<String> radiobuttonTestValues = List.of("metal: value changed to Selen", "metal: value changed to Bronze",
            "metal: value changed to Silver", "metal: value changed to Gold");

        for (int i = 0; i < radiobuttonTestValues.size(); i++) {
            softAssert.assertThat(radiobuttonElements.get(i).getText().contains(radiobuttonTestValues.get(i)));
        }

        // •for dropdown there is a log row and value is corresponded to the selected value.
        List<WebElement> dropdownElements = webDriver.findElements(By.cssSelector("select.uui-form-element option"));

        for (WebElement we : dropdownElements) {
            we.click();
        }

        List<String> dropdownTestElements = List.of("Colors: value changed to Yellow", "Colors: value changed to Blue",
            "Colors: value changed to Green", "Colors: value changed to Red");

        for (int i = 0; i < dropdownTestElements.size(); i++) {
            softAssert.assertThat(dropdownElements.get(i).getText().contains(dropdownTestElements.get(i)));
        }

        softAssert.assertAll();
    }
}
