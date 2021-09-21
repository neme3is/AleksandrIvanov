package com.epam.tc.hw6.exercise1;

import com.epam.tc.hw6.Hw6TestsBaseClass;
import com.epam.tc.hw6.listeners.ScreenshotListener;
import com.epam.tc.hw6.pages.MainPageObject;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ScreenshotListener.class})
public class ExerciseOneTests extends Hw6TestsBaseClass {

    @Test (dataProvider = "ExerciseOneValues", dataProviderClass = ValuesForExerciseOne.class)
    @Feature("Verifying correctness of elements displayed on main page")
    @Story("Logging in and verifying that elements are displayed")
    public void ex1Test(List<String> menuElements, List<String> textsSidebar, List<String> indexPageTexts) {
        MainPageObject mainPageObject = new MainPageObject(webDriver);

        // Log In
        ExerciseOneTestSteps.login(mainPageObject);

        // Assert that there are 4 items on the header section are displayed and they have proper texts
        ExerciseOneTestSteps.assertHeaderElements(mainPageObject, menuElements);

        // Assert that there are 4 images on the Index Page and they are displayed
        ExerciseOneTestSteps.assertImages(mainPageObject);

        // Assert that there are 4 texts on the Index Page under icons and they have proper text
        ExerciseOneTestSteps.assertTextsOnIndexPage(mainPageObject, indexPageTexts);

        // Assert that there is the iframe with “Frame Button” exist
        ExerciseOneTestSteps.assertIframeExists(mainPageObject);

        // Switch to the iframe and check that there is “Frame Button” in the iframe
        ExerciseOneTestSteps.switchToIframe(mainPageObject);
        ExerciseOneTestSteps.checkFrameButton(mainPageObject);

        // Switch to original window back
        ExerciseOneTestSteps.switchToOriginalWindow(mainPageObject);

        // Assert that there are 5 items in the Left Section are displayed and they have proper text
        ExerciseOneTestSteps.assertFiveItemsInLeftSectionDisplayed(mainPageObject, textsSidebar);

    }
}
