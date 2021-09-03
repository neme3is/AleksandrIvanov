package com.epam.tc.hw3.exercise1;

import java.util.List;
import org.testng.annotations.DataProvider;

public class ValuesForExerciseOne {
    @DataProvider(name = "ExerciseOneValues")
    public static Object[][] sidebarTexts() {
        return new Object[][] {
            {List.of("HOME", "CONTACT FORM",
                "SERVICE", "METALS & COLORS"),
                List.of("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs")
            }
        };
    }
}
