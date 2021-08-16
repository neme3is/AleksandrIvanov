package com.epam.tc.hw1.divtest;

import com.epam.tc.hw1.CalcTestsBaseClass;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class DivTest extends CalcTestsBaseClass {

    @Test(dataProvider = "ValuesForDivisionTest", dataProviderClass = ValuesForDivisionTest.class)
    void divResultCheck(long dividend, long divisor, long result) {
        long res = calculator.div(dividend, divisor);
        Assertions.assertThat(result).isEqualTo(res);
    }
}
