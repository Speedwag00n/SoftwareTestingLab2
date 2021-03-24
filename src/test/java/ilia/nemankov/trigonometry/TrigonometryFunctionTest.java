package ilia.nemankov.trigonometry;

import ilia.nemankov.CsvLogger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(value=PER_CLASS)
public class TrigonometryFunctionTest {

    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.0001;

    private TrigonometryFunction trigonometryFunction;

    @AfterAll
    public void logInCSV() {
        trigonometryFunction = new TrigonometryFunction(ACCURACY);
        CsvLogger csvLogger = new CsvLogger("csv_output/trigonometryFunction.csv", -5, 0, 0.1);
        csvLogger.log(trigonometryFunction);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometry_function_test_data.csv")
    public void tableValuesStubsTest(float x, float expected) {
        trigonometryFunction = new TrigonometryFunction(ACCURACY);
        trigonometryFunction.setCos(TrigonometryMocks.getCosMock());
        trigonometryFunction.setCsc(TrigonometryMocks.getCscMock());
        double actual = trigonometryFunction.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

}
