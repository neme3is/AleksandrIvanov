package com.epam.tc.hw1.divtest;

import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DivTest {
    Calculator calculator = new Calculator();

    @DataProvider(name = "TestData")
    public Object[][] dpMethod() {
        return new Object[][] {
            {2415919104L, 2, 1207959552}
        };
    }

    @Test(dataProvider = "TestData")
    void divResultCheck(long a, long b, long c) {
        long result = calculator.div(a, b);
        Assertions.assertThat(result).isEqualTo(c);
    }
}
