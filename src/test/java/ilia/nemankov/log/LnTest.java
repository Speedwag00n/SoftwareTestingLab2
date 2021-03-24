package ilia.nemankov.log;


import ilia.nemankov.CsvLogger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;


@TestInstance(value=PER_CLASS)
public class LnTest {

    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.0001;

    private Ln ln;

    @BeforeAll
    public void init() {
        ln = new Ln(ACCURACY);
    }

    @AfterAll
    public void logInCSV() {
        CsvLogger csvLogger = new CsvLogger("csv_output/ln.csv", 1, 5, 0.1);
        csvLogger.log(ln);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/ln_test_data.csv")
    public void tableValuesTest(float x, float expected) {
        double actual = ln.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void nanTest() {
        double expected = Double.NaN;
        double actual = ln.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        double expected = Double.NaN;;
        double actual = ln.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        double expected = Double.NaN;
        double actual = ln.calculate(Double.NEGATIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

}
