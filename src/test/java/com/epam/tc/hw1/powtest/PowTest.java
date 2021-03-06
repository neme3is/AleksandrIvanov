package com.epam.tc.hw1.powtest;

import com.epam.tc.hw1.CalcTestsBaseClass;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class PowTest extends CalcTestsBaseClass {

    @Test(dataProvider = "ValuesForPowTest", dataProviderClass = ValuesForPowTest.class)
    void powResultCheck(double num, double pow, double result) {
        double res = calculator.pow(num, pow);
        Assertions.assertThat(res).isEqualTo(result);
    }
}
