package ilia.nemankov.trigonometry;


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
public class CosTest {

    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.0001;

    private Cos cos;

    @BeforeAll
    public void init() {
        cos = new Cos(ACCURACY);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/cos_test_data.csv")
    public void tableValuesTest(float x, float expected) {
        double actual = cos.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @AfterAll
    public void logInCSV() {
        CsvLogger csvLogger = new CsvLogger("csv_output/cos.csv", -5, -1, 0.1);
        csvLogger.log(cos);
    }

    @Test
    public void nanTest() {
        double expected = Double.NaN;
        double actual = cos.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        double expected = Double.NaN;;
        double actual = cos.calculate(Double.POSITIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        double expected = Double.NaN;
        double actual = cos.calculate(Double.NEGATIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

}
