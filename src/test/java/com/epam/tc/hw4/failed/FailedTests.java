package com.epam.tc.hw4.failed;

import com.epam.tc.hw4.Hw4TestsBaseClass;
import com.epam.tc.hw4.listeners.ScreenshotListener;
import com.epam.tc.hw4.pages.MainPageObject;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ScreenshotListener.class})
public class FailedTests extends Hw4TestsBaseClass {
    @Test (dataProvider = "ValuesForFailed", dataProviderClass = ValuesForFailed.class)
    public void ex1Test(List<String> menuElements, List<String> textsSidebar, List<String> indexPageTexts, String username,
                        String password, String expectedUsername) {
        SoftAssertions softAssertions = new SoftAssertions();

        MainPageObject mainPageObject = new MainPageObject(webDriver);

        mainPageObject.login(username, password);

        softAssertions.assertThat(mainPageObject.getLoggedInUsername()).isEqualTo(expectedUsername);

        // Assert that there are 4 items on the header section are displayed and they have proper texts
        softAssertions.assertThat(mainPageObject.getHeaderMenu().getHeaderMenuElements())
                      .as("Assert 4 items on the header").hasSize(4);

        softAssertions.assertThat(mainPageObject.getHeaderMenu().getHeaderMenuElements())
                      .allMatch(i -> i.isDisplayed());

        softAssertions.assertThat(menuElements)
                      .allMatch(i -> mainPageObject.getHeaderMenu().verifyElementIsDisplayed(i));

        // Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitImages = mainPageObject.getBenefitImages();
        softAssertions.assertThat(benefitImages).hasSize(4);
        softAssertions.assertThat(benefitImages).allMatch(i -> i.isDisplayed());

        // Assert that there are 4 texts on the Index Page under icons and they have proper text
        softAssertions.assertThat(mainPageObject.getBenefitTexts()).hasSameElementsAs(indexPageTexts);
        softAssertions.assertThat(mainPageObject.getBenefitTexts()).hasSize(4);

        // Assert that there is the iframe with “Frame Button” exist
        softAssertions.assertThat(mainPageObject.getIframeWithFrameButton().isDisplayed()).isTrue();

        // Switch to the iframe and check that there is “Frame Button” in the iframe
        mainPageObject.switchToIframe();
        softAssertions.assertThat(mainPageObject.getIframeButton().isDisplayed()).isTrue();

        // Switch to original window back
        mainPageObject.switchToDefaultWindow();

        // Assert that there are 5 items in the Left Section are displayed and they have proper text
        softAssertions.assertThat(mainPageObject.getLeftSideMenu().getLeftSidebarMenuTexts()).hasSize(5);
        softAssertions.assertThat(mainPageObject.getLeftSideMenu().getLeftSidebarMenuTexts())
                      .hasSameElementsAs(textsSidebar);

        softAssertions.assertThat(mainPageObject.getLeftSideMenu().getLeftSidebarMenuElements())
                      .allMatch(i -> i.isDisplayed());

        softAssertions.assertAll();
    }
}
