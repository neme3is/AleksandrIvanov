package com.epam.tc.hw1.powtest;

import com.epam.tc.hw1.CalcInitialization;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class PowTest extends CalcInitialization {

    @Test(dataProvider = "ValuesForPowTest", dataProviderClass = ValuesForPowTest.class)
    void powResultCheck(double num, double pow, double result) {
        double res = calculator.pow(num, pow);
        Assertions.assertThat(res).isEqualTo(result);
    }
}
