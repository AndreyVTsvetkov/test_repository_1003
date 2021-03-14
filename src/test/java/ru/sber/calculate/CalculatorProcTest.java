package ru.sber.calculate;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorProcTest {

    static CalculatorProc calculatorproc;

    @BeforeClass
    public static void init() {
        calculatorproc = new CalculatorProc();
        calculatorproc.setVal1("569.659854");
        calculatorproc.setVal2("23.563");
    }

    @Test
    public void sumValues() {
        Assert.assertEquals(calculatorproc.sumValues(), "593.222854");
    }

    @Test
    public void divisionValues() {
        Assert.assertEquals(calculatorproc.divisionValues(), "24.176033");
    }

    @Test
    public void subtractionValues() {
        Assert.assertEquals(calculatorproc.subtractionValues(), "546.096854");
    }

    @Test
    public void multiplicationValues() {
        Assert.assertEquals(calculatorproc.multiplicationValues(), "13422.895139802");
    }
}