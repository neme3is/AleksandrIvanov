package com.epam.tc.hw2.exercise2;

import com.epam.tc.hw2.Hw2TestsBaseClass;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ExerciseTwoTests extends Hw2TestsBaseClass {

    @Test
    public void ex2Test() {
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("https://jdi-testing.github.io/jdi-light/index.html", webDriver.getCurrentUrl());
        softAssert.assertEquals("Home Page", webDriver.getTitle());
        webDriver.findElement(By.xpath("//ul[@class='uui-navigation navbar-nav navbar-right']/li[1]/a[1]")).click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();

        softAssert.assertEquals(webDriver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // Open through the header menu Service -> Different Elements Page
        webDriver.findElement(By.xpath(".//ul[@class='uui-navigation nav navbar-nav m-l8']")).click();
        webDriver.findElement(By.xpath(".//a[@href='different-elements.html']")).click();
        softAssert.assertEquals("https://jdi-testing.github.io/jdi-light/different-elements.html",
            webDriver.getCurrentUrl());

        // Select checkboxes water, wind
        List<WebElement> checkboxElements = webDriver.findElements(By
            .xpath("//div[@class='checkbox-row'][1]//input[@type='checkbox']"));
        checkboxElements.get(0).click();
        softAssert.assertTrue(checkboxElements.get(0).isSelected());
        checkboxElements.get(2).click();
        softAssert.assertTrue(checkboxElements.get(2).isSelected());

        // Select radio Selen
        List<WebElement> list3 = webDriver.findElements(By
            .xpath("//div[@class='checkbox-row'][2]//input[@type='radio']"));
        list3.get(3).click();
        softAssert.assertTrue(list3.get(3).isSelected());

        // Select in dropdown Yellow
        webDriver.findElement(By.xpath("//select[@class='uui-form-element']")).click();
        webDriver.findElement((By.xpath("//select[@class='uui-form-element']/option[4]"))).click();
        Select select = new Select(webDriver.findElement(By.xpath("//select[@class='uui-form-element']")));
        String option = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(option, "Yellow");

        /*Assert that:
        •for each checkbox there is an individual log row and value is corresponded to the status of checkbox*/
        checkboxElements.forEach(i -> i.click());
        List<WebElement> checkboxLogElements = webDriver.findElements(By
            .xpath("//ul[@class='panel-body-list logs']/li"));
        softAssert.assertTrue(checkboxLogElements.get(0).getText().contains("Fire: condition changed to true"));
        softAssert.assertTrue(checkboxLogElements.get(1).getText().contains("Wind: condition changed to false"));
        softAssert.assertTrue(checkboxLogElements.get(2).getText().contains("Earth: condition changed to true"));
        softAssert.assertTrue(checkboxLogElements.get(3).getText().contains("Water: condition changed to false"));

        //•for radio button there is a log row and value is corresponded to the status of radio button
        List<WebElement> radiobuttonElements = webDriver.findElements(By
            .xpath("//div[@class='checkbox-row'][2]/label/input"));
        radiobuttonElements.forEach(i -> i.click());
        List<WebElement> radiobuttonLogElements = webDriver.findElements(By
            .xpath("//ul[@class='panel-body-list logs']/li[1 <= position() and position() < 5]"));
        softAssert.assertTrue(radiobuttonElements.get(0).getText().contains("metal: value changed to Selen"));
        softAssert.assertTrue(radiobuttonElements.get(1).getText().contains("metal: value changed to Bronze"));
        softAssert.assertTrue(radiobuttonElements.get(2).getText().contains("metal: value changed to Silver"));
        softAssert.assertTrue(radiobuttonElements.get(3).getText().contains("metal: value changed to Gold"));

        // •for dropdown there is a log row and value is corresponded to the selected value.
        webDriver.findElement(By.xpath("//select[@class='uui-form-element']")).click();
        webDriver.findElements((By.xpath("//select[@class='uui-form-element']/option"))).forEach(i -> i.click());
        List<WebElement> dropdownLogElements = webDriver.findElements(By
            .xpath("//ul[@class='panel-body-list logs']/li[1 <= position() and position() < 5]"));
        softAssert.assertTrue(dropdownLogElements.get(0).getText().contains("Colors: value changed to Yellow"));
        softAssert.assertTrue(dropdownLogElements.get(1).getText().contains("Colors: value changed to Blue"));
        softAssert.assertTrue(dropdownLogElements.get(2).getText().contains("Colors: value changed to Green"));
        softAssert.assertTrue(dropdownLogElements.get(3).getText().contains("Colors: value changed to Red"));
    }
}
