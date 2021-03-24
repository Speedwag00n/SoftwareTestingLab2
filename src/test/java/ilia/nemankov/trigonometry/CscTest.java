package ilia.nemankov.trigonometry;


import ilia.nemankov.CsvLogger;
import org.junit.jupiter.api.AfterAll;
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

    @AfterAll
    public void logInCSV() {
        csc = new Csc(ACCURACY);
        CsvLogger csvLogger = new CsvLogger("csv_output/csc.csv", -5, -1, 0.1);
        csvLogger.log(csc);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csc_test_data.csv")
    public void tableValuesStubsTest(float x, float expected) {
        csc = new Csc(ACCURACY);
        csc.setCos(TrigonometryMocks.getCosMock());
        double actual = csc.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void nanStubsTest() {
        csc = new Csc(ACCURACY);
        csc.setCos(TrigonometryMocks.getCosMock());
        double expected = Double.NaN;
        double actual = csc.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void positiveInfinityStubsTest() {
        csc = new Csc(ACCURACY);
        csc.setCos(TrigonometryMocks.getCosMock());
        double expected = Double.NaN;
        double actual = csc.calculate(Double.POSITIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeInfinityStubsTest() {
        csc = new Csc(ACCURACY);
        csc.setCos(TrigonometryMocks.getCosMock());
        double expected = Double.NaN;
        double actual = csc.calculate(Double.NEGATIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

}
