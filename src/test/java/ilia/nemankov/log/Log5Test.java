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
public class Log5Test {

    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.0001;

    private Log5 log5;

    @AfterAll
    public void logInCSV() {
        log5 = new Log5(ACCURACY);
        CsvLogger csvLogger = new CsvLogger("csv_output/log5.csv", 1, 5, 0.1);
        csvLogger.log(log5);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/log5_test_data.csv")
    public void tableValuesStubsTest(float x, float expected) {
        log5 = new Log5(ACCURACY);
        log5.setLn(LogMocks.getLnMock());
        double actual = log5.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void nanStubsTest() {
        log5 = new Log5(ACCURACY);
        log5.setLn(LogMocks.getLnMock());
        double expected = Double.NaN;
        double actual = log5.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void positiveInfinityStubsTest() {
        log5 = new Log5(ACCURACY);
        log5.setLn(LogMocks.getLnMock());
        double expected = Double.NaN;;
        double actual = log5.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeInfinityStubsTest() {
        log5 = new Log5(ACCURACY);
        log5.setLn(LogMocks.getLnMock());
        double expected = Double.NaN;
        double actual = log5.calculate(Double.NEGATIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

}
