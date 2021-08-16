package com.epam.tc.hw1.multtest;

import com.epam.tc.hw1.CalcTestsBaseClass;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class MultTest extends CalcTestsBaseClass {

    @Test(dataProvider = "ValuesForMultiplicationTest", dataProviderClass = ValuesForMultiplicationTest.class)
    void multResultCheck(long a, long b, long c) {
        long result = calculator.mult(a, b);
        Assertions.assertThat(result).isEqualTo(c);
    }
}
