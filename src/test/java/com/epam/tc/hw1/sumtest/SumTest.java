package com.epam.tc.hw1.sumtest;

import com.epam.tat.module4.Calculator;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class SumTest {
    Calculator calculator = new Calculator();

    @Test (dataProvider = "ValuesForSumTest", dataProviderClass = ValuesForSumTest.class)
        void sumResultCheck(long a, long b, long result) {
        long res = calculator.sum(a, b);
        Assertions.assertThat(res).isEqualTo(result);
    }
}
