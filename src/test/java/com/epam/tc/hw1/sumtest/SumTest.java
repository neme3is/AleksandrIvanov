package com.epam.tc.hw1.sumtest;

import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SumTest {
    Calculator calculator = new Calculator();

    @DataProvider (name = "TestData")
    public Object[][] dpMethod() {
        return new Object[][] {
            {33339, 2147483657L, 2147516996L}
        };
    }

    @Test (dataProvider = "TestData")
        void sumResultCheck(long a, long b, long c) {
        long result = calculator.sum(a, b);
        Assertions.assertThat(result).isEqualTo(c);
    }
}
