package com.epam.tc.hw1.sumtest;

import org.testng.annotations.DataProvider;

public class ValuesForSumTest {
    @DataProvider (name = "ValuesForSumTest")
    public static Object[][] valSumTest() {
        return new Object[][] {
            {33339, 2147483657L, 2147516996L},
            {1999, 20002001, 20004000},
            {544444444, 9999811112L, 10544255556L}
        };
    }
}
