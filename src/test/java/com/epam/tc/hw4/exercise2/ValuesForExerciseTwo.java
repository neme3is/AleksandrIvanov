package com.epam.tc.hw4.exercise2;

import java.util.List;
import org.testng.annotations.DataProvider;

public class ValuesForExerciseTwo {
    @DataProvider(name = "ExerciseTwoValues")
    public static Object[][] sidebarTexts() {
        return new Object[][] {
            {List.of("Fire: condition changed to true",
                "Wind: condition changed to false",
                "Earth: condition changed to true", "Water: condition changed to false"),
                List.of("metal: value changed to Selen",
                    "metal: value changed to Bronze",
                    "metal: value changed to Silver", "metal: value changed to Gold"),
                List.of("Colors: value changed to Yellow",
                    "Colors: value changed to Blue",
                    "Colors: value changed to Green", "Colors: value changed to Red")
            }
        };
    }
}
