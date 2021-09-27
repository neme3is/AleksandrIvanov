package com.epam.tc.hw4.failed;

import com.epam.tc.hw4.utils.TestUtils;
import java.util.List;
import org.testng.annotations.DataProvider;

public class ValuesForFailed {
    @DataProvider(name = "ValuesForFailed")
    public static Object[][] sidebarTexts() {
        return new Object[][] {
            {List.of("HOME", "QCONTACT FORM",
                "SERVICE", "METALS & COLORS"),
                List.of("Home", "Contact forms", "Service",
                    "Metals & Colors", "Elements packs"),
                List.of("To include goood practices and ideas from successful"
                        + " EPAM project",
                    "To be flexible and customizable", "To be multiplatform",
                    "Already have good base (about 20 internal and some external projects), wish to get more…"),
                TestUtils.getUsername(), TestUtils.getPass(), TestUtils.getLoggedInUsername()
            }
        };
    }
}
