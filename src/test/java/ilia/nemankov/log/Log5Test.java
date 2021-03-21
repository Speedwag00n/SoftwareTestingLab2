package ilia.nemankov.log;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;


@TestInstance(value=PER_CLASS)
public class Log5Test {

    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.0001;

    private Log5 log5;

    @BeforeAll
    public void init() {
        log5 = new Log5(ACCURACY);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/log5_test_data.csv")
    public void tableValuesTest(float x, float expected) {
        double actual = log5.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void nanTest() {
        double expected = Double.NaN;
        double actual = log5.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        double expected = Double.NaN;;
        double actual = log5.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        double expected = Double.NaN;
        double actual = log5.calculate(Double.NEGATIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

}
