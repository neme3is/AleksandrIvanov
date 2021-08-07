package com.epam.tc.hw1.subtracttest;

import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubtractTest {
    Calculator calculator = new Calculator();

    @DataProvider(name = "TestData")
    public Object[][] dpMethod() {
        return new Object[][] {
            {2147483657L, 33339, 2147450318L}
        };
    }

    @Test(dataProvider = "TestData")
    void subtractResultCheck(long a, long b, long c) {
        long result = calculator.sub(a, b);
        Assertions.assertThat(result).isEqualTo(c);
    }
}
