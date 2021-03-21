package ilia.nemankov.trigonometry;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;


@TestInstance(value=PER_CLASS)
public class CscTest {

    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.0001;

    private Csc csc;

    @BeforeAll
    public void init() {
        csc = new Csc(ACCURACY);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csc_test_data.csv")
    public void tableValuesTest(float x, float expected) {
        double actual = csc.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void nanTest() {
        double expected = Double.NaN;
        double actual = csc.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void positiveInfinityTest() {
        double expected = Double.NaN;;
        double actual = csc.calculate(Double.POSITIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeInfinityTest() {
        double expected = Double.NaN;
        double actual = csc.calculate(Double.NEGATIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

}
