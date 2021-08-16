package com.epam.tc.hw1.subtracttest;

import com.epam.tc.hw1.CalcTestsBaseClass;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class SubtractTest extends CalcTestsBaseClass {

    @Test(dataProvider = "ValuesForSubtractTest", dataProviderClass = ValuesForSubtractTest.class)
    void subtractResultCheck(long a, long b, long result) {
        long res = calculator.sub(a, b);
        Assertions.assertThat(res).isEqualTo(result);
    }
}
