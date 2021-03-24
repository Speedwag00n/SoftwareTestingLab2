package ilia.nemankov.log;


import ilia.nemankov.CsvLogger;
import org.junit.jupiter.api.AfterAll;
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

    @AfterAll
    public void logInCSV() {
        log10 = new Log10(ACCURACY);
        CsvLogger csvLogger = new CsvLogger("csv_output/log10.csv", 1, 5, 0.1);
        csvLogger.log(log10);
    }

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

}
