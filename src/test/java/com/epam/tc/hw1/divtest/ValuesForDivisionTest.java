package com.epam.tc.hw1.divtest;

import org.testng.annotations.DataProvider;

public class ValuesForDivisionTest {
    @DataProvider (name = "ValuesForDivisionTest")
    public static Object[][] valDivTest() {
        return new Object[][] {
            {2415919104L, 2, 1207959552},
            {2382725210L, 5, 476545042L},
            {128, 2, 64L}
        };
    }
}
