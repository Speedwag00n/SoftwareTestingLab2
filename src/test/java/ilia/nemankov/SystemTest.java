package ilia.nemankov;

import ilia.nemankov.log.*;
import ilia.nemankov.trigonometry.Csc;
import ilia.nemankov.trigonometry.TrigonometryFunction;
import ilia.nemankov.trigonometry.TrigonometryMocks;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(value=PER_CLASS)
public class SystemTest {

    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.0001;

    private FunctionsSystem functionsSystem;

    @AfterAll
    public void logInCSV() {
        functionsSystem = new FunctionsSystem(ACCURACY, new TrigonometryFunction(ACCURACY), new LogFunction(ACCURACY));
        CsvLogger csvLogger = new CsvLogger("csv_output/functionsSystem.csv", -5.1, 4.9, 0.2);
        csvLogger.log(functionsSystem);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/functions_system_test_data.csv")
    public void stubsTest(float x, float expected) {
        functionsSystem = new FunctionsSystem(ACCURACY, SystemMocks.getTrigonometryFunctionMock(), SystemMocks.getLogFunctionMock());
        double actual = functionsSystem.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/functions_system_test_data.csv")
    public void cscStubLogFunStubTest(float x, float expected) {
        TrigonometryFunction trigonometryFunction = new TrigonometryFunction(ACCURACY);
        trigonometryFunction.setCos(TrigonometryMocks.getCosMock());
        trigonometryFunction.setCsc(TrigonometryMocks.getCscMock());
        functionsSystem = new FunctionsSystem(ACCURACY, trigonometryFunction, SystemMocks.getLogFunctionMock());
        double actual = functionsSystem.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/functions_system_test_data.csv")
    public void cscStubLogStubsTest(float x, float expected) {
        TrigonometryFunction trigonometryFunction = new TrigonometryFunction(ACCURACY);
        trigonometryFunction.setCos(TrigonometryMocks.getCosMock());
        trigonometryFunction.setCsc(TrigonometryMocks.getCscMock());
        LogFunction logFunction = new LogFunction(ACCURACY);
        logFunction.setLn(LogMocks.getLnMock());
        logFunction.setLog2(LogMocks.getLog2Mock());
        logFunction.setLog5(LogMocks.getLog5Mock());
        logFunction.setLog10(LogMocks.getLog10Mock());
        functionsSystem = new FunctionsSystem(ACCURACY, trigonometryFunction, logFunction);
        double actual = functionsSystem.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/functions_system_test_data.csv")
    public void cosStubLogStubsTest(float x, float expected) {
        TrigonometryFunction trigonometryFunction = new TrigonometryFunction(ACCURACY);
        trigonometryFunction.setCos(TrigonometryMocks.getCosMock());
        Csc csc = new Csc(ACCURACY);
        csc.setCos(TrigonometryMocks.getCosMock());
        trigonometryFunction.setCsc(csc);
        LogFunction logFunction = new LogFunction(ACCURACY);
        logFunction.setLn(LogMocks.getLnMock());
        logFunction.setLog2(LogMocks.getLog2Mock());
        logFunction.setLog5(LogMocks.getLog5Mock());
        logFunction.setLog10(LogMocks.getLog10Mock());
        functionsSystem = new FunctionsSystem(ACCURACY, trigonometryFunction, logFunction);
        double actual = functionsSystem.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/functions_system_test_data.csv")
    public void cosStubLnStubTest(float x, float expected) {
        TrigonometryFunction trigonometryFunction = new TrigonometryFunction(ACCURACY);
        trigonometryFunction.setCos(TrigonometryMocks.getCosMock());
        Csc csc = new Csc(ACCURACY);
        csc.setCos(TrigonometryMocks.getCosMock());
        trigonometryFunction.setCsc(csc);
        LogFunction logFunction = new LogFunction(ACCURACY);
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
        functionsSystem = new FunctionsSystem(ACCURACY, trigonometryFunction, logFunction);
        double actual = functionsSystem.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/functions_system_test_data.csv")
    public void LnStubTest(float x, float expected) {
        LogFunction logFunction = new LogFunction(ACCURACY);
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
        functionsSystem = new FunctionsSystem(ACCURACY, new TrigonometryFunction(ACCURACY), logFunction);
        double actual = functionsSystem.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/functions_system_test_data.csv")
    public void test(float x, float expected) {
        functionsSystem = new FunctionsSystem(ACCURACY, new TrigonometryFunction(ACCURACY), new LogFunction(ACCURACY));
        double actual = functionsSystem.calculate(x);
        assertEquals(expected, actual, DELTA);
    }

}
