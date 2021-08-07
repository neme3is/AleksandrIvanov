package com.epam.tc.hw1.powtest;

import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PowTest {
    Calculator calculator = new Calculator();

    @DataProvider(name = "TestData")
    public Object[][] dpMethod() {
        return new Object[][] {
            {64, 5, 1073741824}
        };
    }

    @Test(dataProvider = "TestData")
    void powResultCheck(double a, double b, double c) {
        double result = calculator.pow(a, b);
        Assertions.assertThat(result).isEqualTo(c);
    }
}
