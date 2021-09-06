package com.epam.tc.hw4.exercise1;

import com.epam.tc.hw4.pages.MainPageObject;
import com.epam.tc.hw4.utils.TestUtils;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ExerciseOneTestSteps {
    @Step ("User login")
    public static void login (MainPageObject mainPageObject) {
        mainPageObject.login(TestUtils.getUsername(), TestUtils.getPass());
    }

    @Step ("Assert that there are 4 items on the header section are displayed and they have proper texts")
    public static void assertHeaderElements(MainPageObject mainPageObject, List<String> menuElements) {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(mainPageObject.getHeaderMenu().getHeaderMenuElements())
                      .as("Assert 4 items on the header").hasSize(4);

        softAssertions.assertThat(mainPageObject.getHeaderMenu().getHeaderMenuElements())
                      .allMatch(i -> i.isDisplayed());

        softAssertions.assertThat(menuElements)
                      .allMatch(i -> mainPageObject.getHeaderMenu().verifyElementIsDisplayed(i));

        softAssertions.assertAll();
    }

    @Step ("Assert that there are 4 images on the Index Page and they are displayed")
    public static void assertImages(MainPageObject mainPageObject) {
        SoftAssertions softAssertions = new SoftAssertions();
        List<WebElement> benefitImages = mainPageObject.getBenefitImages();
        softAssertions.assertThat(benefitImages).hasSize(4);
        softAssertions.assertThat(benefitImages).allMatch(i -> i.isDisplayed());
        softAssertions.assertAll();
    }

    @Step ("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public static void assertTextsOnIndexPage(MainPageObject mainPageObject, List<String> texts) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(mainPageObject.getBenefitTexts()).hasSameElementsAs(texts);
        softAssertions.assertThat(mainPageObject.getBenefitTexts()).hasSize(4);
        softAssertions.assertAll();
    }

    @Step ("Assert that there is the iframe with “Frame Button” exist")
    public static void assertIframeExists(MainPageObject mainPageObject) {
        Assert.assertTrue(mainPageObject.getIframeWithFrameButton().isDisplayed());
    }

    @Step ("Switch to the iframe")
    public static void switchToIframe(MainPageObject mainPageObject) {
        mainPageObject.switchToIframe();
    }

    @Step ("Check that there is “Frame Button” in the iframe")
    public static void checkFrameButton(MainPageObject mainPageObject) {
        Assert.assertTrue(mainPageObject.getIframeButton().isDisplayed());
    }

    @Step ("Switch to original window")
    public static void switchToOriginalWindow(MainPageObject mainPageObject) {
        mainPageObject.switchToDefaultWindow();
    }

    @Step ("Assert that there are 5 items in the Left Section are displayed and they have proper text")
    public static void assertFiveItemsInLeftSectionDisplayed(MainPageObject mainPageObject,
                                                             List<String> indexPageTexts) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(mainPageObject.getLeftSideMenu().getLeftSidebarMenuTexts()).hasSize(5);
        softAssertions.assertThat(mainPageObject.getLeftSideMenu().getLeftSidebarMenuTexts())
                      .hasSameElementsAs(indexPageTexts);

        softAssertions.assertThat(mainPageObject.getLeftSideMenu().getLeftSidebarMenuElements())
                      .allMatch(i -> i.isDisplayed());

        softAssertions.assertAll();
    }
}
