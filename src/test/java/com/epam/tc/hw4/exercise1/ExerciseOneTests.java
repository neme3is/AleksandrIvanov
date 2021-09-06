package com.epam.tc.hw4.exercise1;

import com.epam.tc.hw4.Hw4TestsBaseClass;
import com.epam.tc.hw4.pages.MainPageObject;
import java.util.List;
import org.testng.annotations.Test;

public class ExerciseOneTests extends Hw4TestsBaseClass {

    @Test (dataProvider = "ExerciseOneValues", dataProviderClass = ValuesForExerciseOne.class)
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
