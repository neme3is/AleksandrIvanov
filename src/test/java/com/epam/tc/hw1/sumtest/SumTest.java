package com.epam.tc.hw1.sumtest;

import com.epam.tc.hw1.CalcTestsBaseClass;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class SumTest extends CalcTestsBaseClass {

    @Test (dataProvider = "ValuesForSumTest", dataProviderClass = ValuesForSumTest.class)
        void sumResultCheck(long a, long b, long result) {
        long res = calculator.sum(a, b);
        Assertions.assertThat(res).isEqualTo(result);
    }
}
