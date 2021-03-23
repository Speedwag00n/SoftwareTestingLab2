package ilia.nemankov.log;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;


@TestInstance(value=PER_CLASS)
public class Log10Test {

    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.0001;

    private Log10 log10;

    @ParameterizedTest
    @CsvFileSource(resources = "/log10_test_data.csv")
    public void tableValuesStubsTest(float x, float expected) {
        log10 = new Log10(ACCURACY);
        log10.setLn(LogMocks.getLnMock());
        double actual = log10.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void nanStubsTest() {
        log10 = new Log10(ACCURACY);
        log10.setLn(LogMocks.getLnMock());
        double expected = Double.NaN;
        double actual = log10.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void positiveInfinityStubsTest() {
        log10 = new Log10(ACCURACY);
        log10.setLn(LogMocks.getLnMock());
        double expected = Double.NaN;
        double actual = log10.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeInfinityStubsTest() {
        log10 = new Log10(ACCURACY);
        log10.setLn(LogMocks.getLnMock());
        double expected = Double.NaN;
        double actual = log10.calculate(Double.NEGATIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/log10_test_data.csv")
    public void tableValuesTest(float x, float expected) {
        log10 = new Log10(ACCURACY);
        double actual = log10.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void nanTest() {
        log10 = new Log10(ACCURACY);
        double expected = Double.NaN;
        double actual = log10.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        log10 = new Log10(ACCURACY);
        double expected = Double.NaN;
        double actual = log10.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        log10 = new Log10(ACCURACY);
        double expected = Double.NaN;
        double actual = log10.calculate(Double.NEGATIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

}
