package com.epam.tc.hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeClass;

public class CalcTestsBaseClass {
    protected Calculator calculator;

    @BeforeClass
    public void calcInit() {
        calculator = new Calculator();
    }
}
