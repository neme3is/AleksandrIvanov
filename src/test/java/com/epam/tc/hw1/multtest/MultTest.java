package com.epam.tc.hw1.multtest;

import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultTest {
    Calculator calculator = new Calculator();

    @DataProvider(name = "TestData")
    public Object[][] dpMethod() {
        return new Object[][] {
            {4096, 589824, 2415919104L}
        };
    }

    @Test(dataProvider = "TestData")
    void multResultCheck(long a, long b, long c) {
        long result = calculator.mult(a, b);
        Assertions.assertThat(result).isEqualTo(c);
    }
}
