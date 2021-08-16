package com.epam.tc.hw1.subtracttest;

import org.testng.annotations.DataProvider;

public class ValuesForSubtractTest {
    @DataProvider (name = "ValuesForSubtractTest")
    public static Object[][] valSubtractTest() {
        return new Object[][] {
            {2147483657L, 33339, 2147450318L},
            {5555555, 9991, 5545564},
            {8117717162L, 9000, 8117708162L}
        };
    }
}
