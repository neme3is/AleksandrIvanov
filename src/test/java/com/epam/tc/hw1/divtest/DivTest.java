package com.epam.tc.hw1.divtest;

import com.epam.tc.hw1.CalcInitialization;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class DivTest extends CalcInitialization {

    @Test(dataProvider = "ValuesForDivisionTest", dataProviderClass = ValuesForDivisionTest.class)
    void divResultCheck(long dividend, long divisor, long result) {
        long res = calculator.div(dividend, divisor);
        Assertions.assertThat(result).isEqualTo(res);
    }
}
