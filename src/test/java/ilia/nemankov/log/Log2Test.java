package ilia.nemankov.log;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;


@TestInstance(value=PER_CLASS)
public class Log2Test {

    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.0001;

    private Log2 log2;

    @ParameterizedTest
    @CsvFileSource(resources = "/log2_test_data.csv")
    public void tableValuesStubsTest(float x, float expected) {
        log2 = new Log2(ACCURACY);
        log2.setLn(LogMocks.getLnMock());
        double actual = log2.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void nanStubsTest() {
        log2 = new Log2(ACCURACY);
        log2.setLn(LogMocks.getLnMock());
        double expected = Double.NaN;
        double actual = log2.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void positiveInfinityStubsTest() {
        log2 = new Log2(ACCURACY);
        log2.setLn(LogMocks.getLnMock());
        double expected = Double.NaN;;
        double actual = log2.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeInfinityStubsTest() {
        log2 = new Log2(ACCURACY);
        log2.setLn(LogMocks.getLnMock());
        double expected = Double.NaN;
        double actual = log2.calculate(Double.NEGATIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/log2_test_data.csv")
    public void tableValuesTest(float x, float expected) {
        log2 = new Log2(ACCURACY);
        double actual = log2.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void nanTest() {
        log2 = new Log2(ACCURACY);
        double expected = Double.NaN;
        double actual = log2.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        log2 = new Log2(ACCURACY);
        double expected = Double.NaN;;
        double actual = log2.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        log2 = new Log2(ACCURACY);
        double expected = Double.NaN;
        double actual = log2.calculate(Double.NEGATIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

}
