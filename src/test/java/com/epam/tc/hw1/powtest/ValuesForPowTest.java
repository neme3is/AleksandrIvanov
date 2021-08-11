package com.epam.tc.hw1.powtest;

import org.testng.annotations.DataProvider;

public class ValuesForPowTest {
    @DataProvider (name = "ValuesForPowTest")
    public static Object[][] valPowTest() {
        return new Object[][] {
            {2, 7, 128},
            {3, 11, 177147},
            {5, 14, 6103515625L}
        };
    }
}
