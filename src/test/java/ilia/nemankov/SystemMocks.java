package ilia.nemankov;

import ilia.nemankov.log.LogFunction;
import ilia.nemankov.trigonometry.Cos;
import ilia.nemankov.trigonometry.Csc;
import org.mockito.AdditionalMatchers;

import static java.lang.Double.NaN;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SystemMocks {

    public static LogFunction getLogFunctionMock() {
        LogFunction logFunction = mock(LogFunction.class);

        when(logFunction.calculate(AdditionalMatchers.eq(0.0, 0.1))).thenReturn(NaN);
        when(logFunction.calculate(AdditionalMatchers.eq(0.5, 0.1))).thenReturn(-0.946261);
        when(logFunction.calculate(AdditionalMatchers.eq(0.8, 0.1))).thenReturn(-0.088937);
        when(logFunction.calculate(AdditionalMatchers.eq(1.0, 0.1))).thenReturn(0.0);
        when(logFunction.calculate(AdditionalMatchers.eq(1.2, 0.1))).thenReturn(-0.054115);
        when(logFunction.calculate(AdditionalMatchers.eq(1.5, 0.1))).thenReturn(-0.253324);

        return logFunction;
    }

    public static LogFunction getTrigonometryFunctionMock() {
        LogFunction logFunction = mock(LogFunction.class);

        when(logFunction.calculate(AdditionalMatchers.eq(-3.1415927, 0.1))).thenReturn(NaN);
        when(logFunction.calculate(AdditionalMatchers.eq(-2.3561945, 0.1))).thenReturn(1.0);
        when(logFunction.calculate(AdditionalMatchers.eq(-1.5707963, 0.1))).thenReturn(0.0);
        when(logFunction.calculate(AdditionalMatchers.eq(-0.7853982, 0.1))).thenReturn(-1.0);
        when(logFunction.calculate(AdditionalMatchers.eq(0.0, 0.1))).thenReturn(NaN);
        when(logFunction.calculate(AdditionalMatchers.eq(0.7853982, 0.1))).thenReturn(1.0);
        when(logFunction.calculate(AdditionalMatchers.eq(1.5707963, 0.1))).thenReturn(0.0);
        when(logFunction.calculate(AdditionalMatchers.eq(2.3561945, 0.1))).thenReturn(-1.0);
        when(logFunction.calculate(AdditionalMatchers.eq(3.1415927, 0.1))).thenReturn(NaN);

        return logFunction;
    }

}
