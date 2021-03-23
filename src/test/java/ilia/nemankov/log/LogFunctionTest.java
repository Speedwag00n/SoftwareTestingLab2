package ilia.nemankov.log;


import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;


@TestInstance(value=PER_CLASS)
public class LogFunctionTest {

    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.0001;

    private LogFunction logFunction;

    @ParameterizedTest
    @CsvFileSource(resources = "/log_function_test_data.csv")
    public void tableValuesStubsTest(float x, float expected) {
        logFunction = new LogFunction(ACCURACY);
        logFunction.setLn(LogMocks.getLnMock());
        logFunction.setLog2(LogMocks.getLog2Mock());
        logFunction.setLog5(LogMocks.getLog5Mock());
        logFunction.setLog10(LogMocks.getLog10Mock());
        double actual = logFunction.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/log_function_test_data.csv")
    public void tableValuesLnStubTest(float x, float expected) {
        logFunction = new LogFunction(ACCURACY);
        logFunction.setLn(LogMocks.getLnMock());
        Log2 log2 = new Log2(ACCURACY);
        log2.setLn(LogMocks.getLnMock());
        logFunction.setLog2(log2);
        Log5 log5 = new Log5(ACCURACY);
        log5.setLn(LogMocks.getLnMock());
        logFunction.setLog5(log5);
        Log10 log10 = new Log10(ACCURACY);
        log10.setLn(LogMocks.getLnMock());
        logFunction.setLog10(log10);
        double actual = logFunction.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/log_function_test_data.csv")
    public void tableValuesTest(float x, float expected) {
        logFunction = new LogFunction(ACCURACY);
        double actual = logFunction.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

}
