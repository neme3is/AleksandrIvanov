package com.epam.tc.hw2.exercise1;

import com.epam.tc.hw2.Hw2TestsBaseClass;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ExerciseOneTests extends Hw2TestsBaseClass {

    @Test
    public void ex1Test() {
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("https://jdi-testing.github.io/jdi-light/index.html", webDriver.getCurrentUrl());
        softAssert.assertEquals("Home Page", webDriver.getTitle());
        webDriver.findElement(By.xpath("//ul[@class='uui-navigation navbar-nav navbar-right']/li[1]/a[1]")).click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();
        softAssert.assertEquals(webDriver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        // Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertEquals(webDriver.findElements(By
            .xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a")).size(), 4);
        webDriver.findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li/a"))
                 .forEach(i -> softAssert.assertTrue(i.isDisplayed()));
        softAssert.assertEquals(webDriver.findElements(By
            .xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/*[contains(text(),'HOME') "
            + "or contains(text(),'CONTACT FORM') or contains(text(),'SERVICE') "
                + "or contains(text(),'METALS & COLORS')]")).size(), 4);

        // Assert that there are 4 images on the Index Page and they are displayed
        webDriver.findElements(By.cssSelector("benefit-icon")).forEach(i -> softAssert.assertTrue(i.isDisplayed()));

        // Assert that there are 4 texts on the Index Page under icons and they have proper text
        ArrayList<String> texts = new ArrayList<>(Arrays
            .asList("To include good practices and ideas from successful EPAM project",
            "To be flexible and customizable", "To be multiplatform",
                "Already have good base (about 20 internal and some external projects), wish to get more…"));
        List<WebElement> list = webDriver.findElements(By.className("benefit-txt"));
        softAssert.assertEquals(list.get(0).getAttribute("innerHTML").split("<br>"), texts.get(0));
        softAssert.assertEquals(list.get(1).getAttribute("innerHTML").split("<br>"), texts.get(1));
        softAssert.assertEquals(list.get(2).getAttribute("innerHTML").split("<br>"), texts.get(2));
        softAssert.assertEquals(list.get(3).getAttribute("innerHTML").split("<br>"), texts.get(3));
        list.forEach(i -> softAssert.assertTrue(i.isDisplayed()));

        // Assert that there is the iframe with “Frame Button” exist
        softAssert.assertTrue(webDriver.findElements(By
            .xpath("//iframe[starts-with(@src, 'https://jdi-testing.github.io/jdi-light/frame-button.html')]"))
                                       .size() > 0);

        // Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        softAssert.assertTrue(webDriver.findElement(By.xpath("//input[@value='Frame Button']")).isDisplayed());

        // Switch to original window back
        webDriver.switchTo().defaultContent();

        // Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> we = webDriver.findElements(By.xpath("//div[@name='navigation-sidebar']//li"));
        ArrayList<String> texts1 = new ArrayList<>(Arrays.asList("Home", "Contact form", "Service",
            "Metals & Colors", "Elements packs"));
        softAssert.assertEquals(we.get(0).getAttribute("innerHTML").split("<br>"), texts1.get(0));
        softAssert.assertEquals(we.get(1).getAttribute("innerHTML").split("<br>"), texts1.get(1));
        softAssert.assertEquals(we.get(2).getAttribute("innerHTML").split("<br>"), texts1.get(2));
        softAssert.assertEquals(we.get(3).getAttribute("innerHTML").split("<br>"), texts1.get(3));
        softAssert.assertEquals(we.get(4).getAttribute("innerHTML").split("<br>"), texts1.get(4));
    }
}
