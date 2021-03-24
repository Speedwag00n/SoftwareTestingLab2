package ilia.nemankov.log;


import ilia.nemankov.CsvLogger;
import org.junit.jupiter.api.AfterAll;
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

    @AfterAll
    public void logInCSV() {
        logFunction = new LogFunction(ACCURACY);
        CsvLogger csvLogger = new CsvLogger("csv_output/logFunction.csv", 1, 5, 0.1);
        csvLogger.log(logFunction);
    }

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

}
