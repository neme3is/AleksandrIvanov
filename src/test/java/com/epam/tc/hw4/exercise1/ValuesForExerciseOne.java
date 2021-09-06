package com.epam.tc.hw4.exercise1;

import java.util.List;
import org.testng.annotations.DataProvider;

public class ValuesForExerciseOne {
    @DataProvider(name = "ExerciseOneValues")
    public static Object[][] sidebarTexts() {
        return new Object[][] {
            {List.of("HOME", "CONTACT FORM",
                "SERVICE", "METALS & COLORS"),
                List.of("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs"),
                List.of("To include good practices and ideas from successful"
                        + " EPAM project",
                    "To be flexible and customizable", "To be multiplatform",
                    "Already have good base (about 20 internal and some external projects), wish to get more…")
            }
        };
    }
}
