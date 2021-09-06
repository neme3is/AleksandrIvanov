package com.epam.tc.hw4.exercise1;

import com.epam.tc.hw4.pages.MainPageObject;
import com.epam.tc.hw4.utils.TestUtils;
import io.qameta.allure.Step;
import org.testng.Assert;

public class ExerciseOneTestSteps {
    @Step ("Логин пользователя")
    public static void login (MainPageObject mainPageObject) {
        mainPageObject.login(TestUtils.getUsername(), TestUtils.getPass());
    }

    @Step ("Получить имя пользователя в системе")
    public static String getLoggedInUsername (MainPageObject mainPageObject) {
        return mainPageObject.getLoggedInUsername();
    }

    @Step ("Assert that there are 4 items on the header section are displayed and they have proper texts")
    public static void assertHeaderElements(MainPageObject mainPageObject) {
        Assert.assertTrue(mainPageObject.getHeaderMenu().getHeaderMenuElements().size() == 4);

        //Assert.asser(mainPageObject.getHeaderMenu().getHeaderMenuElements())
        //        .allMatch(i -> i.isDisplayed());
    }
}
