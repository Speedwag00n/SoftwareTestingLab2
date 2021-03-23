package ilia.nemankov.trigonometry;

import org.mockito.AdditionalMatchers;

import static java.lang.Double.NaN;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TrigonometryMocks {

    public static Cos getCosMock() {
        Cos cos = mock(Cos.class);

        when(cos.calculate(AdditionalMatchers.eq(0.0, 0.1))).thenReturn(1.0);
        when(cos.calculate(AdditionalMatchers.eq(0.5235988, 0.1))).thenReturn(0.8660254);
        when(cos.calculate(AdditionalMatchers.eq(0.7853982, 0.1))).thenReturn(0.7071068);
        when(cos.calculate(AdditionalMatchers.eq(1.0471976, 0.1))).thenReturn(0.5);
        when(cos.calculate(AdditionalMatchers.eq(1.5707963, 0.1))).thenReturn(0.0);
        when(cos.calculate(AdditionalMatchers.eq(2.0943951, 0.1))).thenReturn(-0.5);
        when(cos.calculate(AdditionalMatchers.eq(2.3561945, 0.1))).thenReturn(-0.7071068);
        when(cos.calculate(AdditionalMatchers.eq(2.6179939, 0.1))).thenReturn(-0.8660254);
        when(cos.calculate(AdditionalMatchers.eq(3.1415927, 0.1))).thenReturn(-1.0);
        when(cos.calculate(AdditionalMatchers.eq(3.6651914, 0.1))).thenReturn(0.8660254);
        when(cos.calculate(AdditionalMatchers.eq(3.9269908, 0.1))).thenReturn(0.7071068);
        when(cos.calculate(AdditionalMatchers.eq(4.1887902, 0.1))).thenReturn(0.5);
        when(cos.calculate(AdditionalMatchers.eq(4.7123890, 0.1))).thenReturn(0.0);
        when(cos.calculate(AdditionalMatchers.eq(5.2359878, 0.1))).thenReturn(0.5);
        when(cos.calculate(AdditionalMatchers.eq(5.4977871, 0.1))).thenReturn(0.7071068);
        when(cos.calculate(AdditionalMatchers.eq(5.7595865, 0.1))).thenReturn(0.8660254);
        when(cos.calculate(AdditionalMatchers.eq(6.2831853, 0.1))).thenReturn(1.0);
        when(cos.calculate(AdditionalMatchers.eq(-0.5235988, 0.1))).thenReturn(0.8660254);
        when(cos.calculate(AdditionalMatchers.eq(-0.7853982, 0.1))).thenReturn(0.7071068);
        when(cos.calculate(AdditionalMatchers.eq(-1.0471976, 0.1))).thenReturn(0.5);
        when(cos.calculate(AdditionalMatchers.eq(-1.5707963, 0.1))).thenReturn(0.0);
        when(cos.calculate(AdditionalMatchers.eq(-2.0943951, 0.1))).thenReturn(-0.5);
        when(cos.calculate(AdditionalMatchers.eq(-2.3561945, 0.1))).thenReturn(-0.7071068);
        when(cos.calculate(AdditionalMatchers.eq(-2.6179939, 0.1))).thenReturn(-0.8660254);
        when(cos.calculate(AdditionalMatchers.eq(-3.1415927, 0.1))).thenReturn(-1.0);
        when(cos.calculate(AdditionalMatchers.eq(-3.6651914, 0.1))).thenReturn(0.8660254);
        when(cos.calculate(AdditionalMatchers.eq(-3.9269908, 0.1))).thenReturn(0.7071068);
        when(cos.calculate(AdditionalMatchers.eq(-4.1887902, 0.1))).thenReturn(0.5);
        when(cos.calculate(AdditionalMatchers.eq(-4.7123890, 0.1))).thenReturn(0.0);
        when(cos.calculate(AdditionalMatchers.eq(-5.2359878, 0.1))).thenReturn(0.5);
        when(cos.calculate(AdditionalMatchers.eq(-5.4977871, 0.1))).thenReturn(0.7071068);
        when(cos.calculate(AdditionalMatchers.eq(-5.7595865, 0.1))).thenReturn(0.8660254);
        when(cos.calculate(AdditionalMatchers.eq(-6.2831853, 0.1))).thenReturn(1.0);
        when(cos.calculate(Double.POSITIVE_INFINITY)).thenReturn(NaN);
        when(cos.calculate(Double.NEGATIVE_INFINITY)).thenReturn(NaN);
        when(cos.calculate(NaN)).thenReturn(NaN);

        return cos;
    }

    public static Csc getCscMock() {
        Csc csc = mock(Csc.class);

        when(csc.calculate(AdditionalMatchers.eq(0.0, 0.1))).thenReturn(NaN);
        when(csc.calculate(AdditionalMatchers.eq(0.5235988, 0.1))).thenReturn(2.0);
        when(csc.calculate(AdditionalMatchers.eq(0.7853982, 0.1))).thenReturn(1.4142136);
        when(csc.calculate(AdditionalMatchers.eq(1.0471976, 0.1))).thenReturn(1.1547005);
        when(csc.calculate(AdditionalMatchers.eq(1.5707963, 0.1))).thenReturn(1.0);
        when(csc.calculate(AdditionalMatchers.eq(2.0943951, 0.1))).thenReturn(1.1547005);
        when(csc.calculate(AdditionalMatchers.eq(2.3561945, 0.1))).thenReturn(1.4142136);
        when(csc.calculate(AdditionalMatchers.eq(2.6179939, 0.1))).thenReturn(2.0);
        when(csc.calculate(AdditionalMatchers.eq(3.1415927, 0.1))).thenReturn(NaN);
        when(csc.calculate(AdditionalMatchers.eq(3.6651914, 0.1))).thenReturn(-2.0);
        when(csc.calculate(AdditionalMatchers.eq(3.9269908, 0.1))).thenReturn(-1.4142136);
        when(csc.calculate(AdditionalMatchers.eq(4.1887902, 0.1))).thenReturn(-1.1547005);
        when(csc.calculate(AdditionalMatchers.eq(4.7123890, 0.1))).thenReturn(-1.0);
        when(csc.calculate(AdditionalMatchers.eq(5.2359878, 0.1))).thenReturn(-1.1547005);
        when(csc.calculate(AdditionalMatchers.eq(5.4977871, 0.1))).thenReturn(-1.4142136);
        when(csc.calculate(AdditionalMatchers.eq(5.7595865, 0.1))).thenReturn(-2.0);
        when(csc.calculate(AdditionalMatchers.eq(6.2831853, 0.1))).thenReturn(NaN);
        when(csc.calculate(AdditionalMatchers.eq(-0.5235988, 0.1))).thenReturn(-2.0);
        when(csc.calculate(AdditionalMatchers.eq(-0.7853982, 0.1))).thenReturn(-1.4142136);
        when(csc.calculate(AdditionalMatchers.eq(-1.0471976, 0.1))).thenReturn(-1.1547005);
        when(csc.calculate(AdditionalMatchers.eq(-1.5707963, 0.1))).thenReturn(-1.0);
        when(csc.calculate(AdditionalMatchers.eq(-2.0943951, 0.1))).thenReturn(-1.1547005);
        when(csc.calculate(AdditionalMatchers.eq(-2.3561945, 0.1))).thenReturn(-1.4142136);
        when(csc.calculate(AdditionalMatchers.eq(-2.6179939, 0.1))).thenReturn(-2.0);
        when(csc.calculate(AdditionalMatchers.eq(-3.1415927, 0.1))).thenReturn(NaN);
        when(csc.calculate(AdditionalMatchers.eq(-3.6651914, 0.1))).thenReturn(2.0);
        when(csc.calculate(AdditionalMatchers.eq(-3.9269908, 0.1))).thenReturn(1.4142136);
        when(csc.calculate(AdditionalMatchers.eq(-4.1887902, 0.1))).thenReturn(1.1547005);
        when(csc.calculate(AdditionalMatchers.eq(-4.7123890, 0.1))).thenReturn(1.0);
        when(csc.calculate(AdditionalMatchers.eq(-5.2359878, 0.1))).thenReturn(1.1547005);
        when(csc.calculate(AdditionalMatchers.eq(-5.4977871, 0.1))).thenReturn(1.4142136);
        when(csc.calculate(AdditionalMatchers.eq(-5.7595865, 0.1))).thenReturn(2.0);
        when(csc.calculate(AdditionalMatchers.eq(-6.2831853, 0.1))).thenReturn(NaN);

        return csc;
    }

}
