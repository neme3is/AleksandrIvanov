package com.epam.tc.hw2.exercise1;

import com.epam.tc.hw2.Hw2TestsBaseClass;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExerciseOneTests extends Hw2TestsBaseClass {

    SoftAssertions softAssert = new SoftAssertions();

    @Test
    public void ex1Test() {
        webDriver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");

        softAssert.assertThat("https://jdi-testing.github.io/jdi-light/index.html")
                  .isEqualTo(webDriver.getCurrentUrl());
        softAssert.assertThat("Home Page").isEqualTo(webDriver.getTitle());

        webDriver.findElement(By.id("user-icon")).click();
        webDriver.findElement(By.id("name")).sendKeys("Roman");
        webDriver.findElement(By.id("password")).sendKeys("Jdi1234");
        webDriver.findElement(By.id("login-button")).click();

        softAssert.assertThat(webDriver.findElement(By.id("user-name")).getText()).isEqualTo("ROMAN IOVLEV");

        // Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssert.assertThat(webDriver.findElements(By.cssSelector(".m-l8 > li > a:first-child")).size() == 4);

        softAssert.assertThat(webDriver.findElements(By.cssSelector(".m-l8 > li > a:first-child")))
                  .allMatch(i -> i.isDisplayed());

        softAssert.assertThat(webDriver.findElement(By.linkText("HOME")).isDisplayed());
        softAssert.assertThat(webDriver.findElement(By.linkText("CONTACT FORM")).isDisplayed());
        softAssert.assertThat(webDriver.findElement(By.linkText("SERVICE")).isDisplayed());
        softAssert.assertThat(webDriver.findElement(By.linkText("METALS & COLORS")).isDisplayed());

        // Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertThat(webDriver.findElements(By.className("benefit-icon")).size() == 4);
        softAssert.assertThat(webDriver.findElements(By.className("benefit-icon"))).allMatch(i -> i.isDisplayed());

        // Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> texts = List.of("To include good practices and ideas from successful EPAM project",
            "To be flexible and customizable", "To be multiplatform",
            "Already have good base (about 20 internal and some external projects), wish to get more…");
        List<WebElement> list = webDriver.findElements(By.className("benefit-txt"));

        for (int i = 0; i < texts.size(); i++) {
            softAssert.assertThat(list.get(i).getText().replaceAll("\n", " ")).isEqualTo(texts.get(i));
        }

        softAssert.assertThat(list).allMatch(i -> i.isDisplayed());

        // Assert that there is the iframe with “Frame Button” exist
        softAssert.assertThat(webDriver.findElement(By.id("frame")).isDisplayed());

        // Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        softAssert.assertThat(webDriver.findElement(By.xpath("//input[@value='Frame Button']")).isDisplayed());

        // Switch to original window back
        webDriver.switchTo().defaultContent();

        // Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> sidebarElements = webDriver.findElements(By.cssSelector(".left > li > a > span"));
        List<String> textsSidebar = List.of("Home", "Contact form", "Service",
            "Metals & Colors", "Elements packs");

        for (int i = 0; i < textsSidebar.size(); i++) {
            softAssert.assertThat(sidebarElements.get(i).getText().replaceAll("\n", " "))
                      .isEqualTo(textsSidebar.get(i));
        }

        softAssert.assertThat(sidebarElements).allMatch(i -> i.isDisplayed());

        softAssert.assertAll();
    }
}
