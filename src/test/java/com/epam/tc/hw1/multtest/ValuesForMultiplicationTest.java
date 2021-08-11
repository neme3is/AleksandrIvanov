package com.epam.tc.hw1.multtest;

import org.testng.annotations.DataProvider;

public class ValuesForMultiplicationTest {
    @DataProvider (name = "ValuesForMultiplicationTest")
    public static Object[][] valMultTest() {
        return new Object[][] {
            {4096, 589824, 2415919104L},
            {16926, 32981, 558236406L},
            {2683, 55, 147565}
        };
    }
}
