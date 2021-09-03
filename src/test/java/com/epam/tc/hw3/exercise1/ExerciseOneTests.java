package com.epam.tc.hw3.exercise1;

import com.epam.tc.hw3.Hw3TestsBaseClass;
import com.epam.tc.hw3.pages.MainPageObject;
import com.epam.tc.hw3.utils.TestUtils;
import java.io.IOException;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ExerciseOneTests extends Hw3TestsBaseClass {

    @Test (dataProvider = "ExerciseOneValues", dataProviderClass = ValuesForExerciseOne.class)
    public void ex1Test(List<String> menuElements, List<String> textsSidebar) {
        SoftAssertions softAssertions = new SoftAssertions();

        MainPageObject mainPageObject = new MainPageObject(webDriver);

        mainPageObject.login(TestUtils.getUsername(), TestUtils.getPass());

        softAssertions.assertThat(mainPageObject.getLoggedInUsername()).isEqualTo(TestUtils.getLoggedInUsername());

        // Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssertions.assertThat(mainPageObject.getHeaderMenu().getHeaderMenuElements())
                      .as("Assert 4 items on the header").hasSize(4);

        softAssertions.assertThat(mainPageObject.getHeaderMenu().getHeaderMenuElements())
                  .allMatch(i -> i.isDisplayed());

        softAssertions.assertThat(menuElements)
                      .allMatch(i -> mainPageObject.getHeaderMenu().verifyElementIsDisplayed(i));

        // Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitImages = mainPageObject.getBenefitImages();
        softAssertions.assertThat(benefitImages.size()).isEqualTo(4);
        softAssertions.assertThat(benefitImages).allMatch(i -> i.isDisplayed());

        // Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssertions.assertThat(mainPageObject.getBenefitTexts()).hasSameElementsAs(TEXTS);
        softAssertions.assertThat(mainPageObject.getBenefitTexts().size()).isEqualTo(4);

        // Assert that there is the iframe with “Frame Button” exist
        softAssertions.assertThat(mainPageObject.getIframeWithFrameButton().isDisplayed()).isTrue();

        // Switch to the iframe and check that there is “Frame Button” in the iframe
        mainPageObject.switchToIframe();
        softAssertions.assertThat(mainPageObject.getIframeButton().isDisplayed()).isTrue();

        // Switch to original window back
        mainPageObject.switchToDefaultWindow();

        // Assert that there are 5 items in the Left Section are displayed and they have proper text
        softAssertions.assertThat(mainPageObject.getLeftSideMenu().getLeftSidebarMenuTexts().size()).isEqualTo(5);
        softAssertions.assertThat(mainPageObject.getLeftSideMenu().getLeftSidebarMenuTexts())
                      .hasSameElementsAs(textsSidebar);

        softAssertions.assertThat(mainPageObject.getLeftSideMenu().getLeftSidebarMenuElements())
                      .allMatch(i -> i.isDisplayed());

        softAssertions.assertAll();
    }
}
