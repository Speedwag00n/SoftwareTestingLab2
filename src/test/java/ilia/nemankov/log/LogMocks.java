package ilia.nemankov.log;

import org.mockito.AdditionalMatchers;

import static java.lang.Double.NaN;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LogMocks {

    public static Ln getLnMock() {
        Ln ln = mock(Ln.class);

        when(ln.calculate(AdditionalMatchers.eq(0.0, 0.1))).thenReturn(NaN);
        when(ln.calculate(AdditionalMatchers.eq(0.5, 0.1))).thenReturn(-0.693147);
        when(ln.calculate(AdditionalMatchers.eq(0.8, 0.1))).thenReturn(-0.223144);
        when(ln.calculate(AdditionalMatchers.eq(1.0, 0.1))).thenReturn(0.0);
        when(ln.calculate(AdditionalMatchers.eq(1.2, 0.1))).thenReturn(0.18322);
        when(ln.calculate(AdditionalMatchers.eq(1.5, 0.1))).thenReturn(0.405465);
        when(ln.calculate(AdditionalMatchers.eq(2.0, 0.1))).thenReturn(0.6931472);
        when(ln.calculate(AdditionalMatchers.eq(3.0, 0.1))).thenReturn(1.0986122);
        when(ln.calculate(AdditionalMatchers.eq(4.0, 0.1))).thenReturn(1.3862944);
        when(ln.calculate(AdditionalMatchers.eq(5.0, 0.1))).thenReturn(1.6094379);
        when(ln.calculate(AdditionalMatchers.eq(6.0, 0.1))).thenReturn(1.7917595);
        when(ln.calculate(AdditionalMatchers.eq(7.0, 0.1))).thenReturn(1.9459101);
        when(ln.calculate(AdditionalMatchers.eq(8.0, 0.1))).thenReturn(2.0794415);
        when(ln.calculate(AdditionalMatchers.eq(9.0, 0.1))).thenReturn(2.1972246);
        when(ln.calculate(AdditionalMatchers.eq(10.0, 0.1))).thenReturn(2.3025851);
        when(ln.calculate(Double.POSITIVE_INFINITY)).thenReturn(NaN);
        when(ln.calculate(Double.NEGATIVE_INFINITY)).thenReturn(NaN);
        when(ln.calculate(NaN)).thenReturn(NaN);

        return ln;
    }

    public static Log2 getLog2Mock() {
        Log2 log2 = mock(Log2.class);

        when(log2.calculate(AdditionalMatchers.eq(0.0, 0.1))).thenReturn(NaN);
        when(log2.calculate(AdditionalMatchers.eq(0.5, 0.1))).thenReturn(-1.0);
        when(log2.calculate(AdditionalMatchers.eq(0.8, 0.1))).thenReturn(-0.3219281);
        when(log2.calculate(AdditionalMatchers.eq(1.0, 0.1))).thenReturn(0.0);
        when(log2.calculate(AdditionalMatchers.eq(1.2, 0.1))).thenReturn(0.26303444);
        when(log2.calculate(AdditionalMatchers.eq(1.5, 0.1))).thenReturn(0.58496250);

        return log2;
    }

    public static Log5 getLog5Mock() {
        Log5 log5 = mock(Log5.class);

        when(log5.calculate(AdditionalMatchers.eq(0.0, 0.1))).thenReturn(NaN);
        when(log5.calculate(AdditionalMatchers.eq(0.5, 0.1))).thenReturn(-0.430677);
        when(log5.calculate(AdditionalMatchers.eq(0.8, 0.1))).thenReturn(-0.138647);
        when(log5.calculate(AdditionalMatchers.eq(1.0, 0.1))).thenReturn(0.0);
        when(log5.calculate(AdditionalMatchers.eq(1.2, 0.1))).thenReturn(0.113283);
        when(log5.calculate(AdditionalMatchers.eq(1.5, 0.1))).thenReturn(0.251930);

        return log5;
    }

    public static Log10 getLog10Mock() {
        Log10 log10 = mock(Log10.class);

        when(log10.calculate(AdditionalMatchers.eq(0.0, 0.1))).thenReturn(NaN);
        when(log10.calculate(AdditionalMatchers.eq(0.5, 0.1))).thenReturn(-0.301030);
        when(log10.calculate(AdditionalMatchers.eq(0.8, 0.1))).thenReturn(-0.0969100);
        when(log10.calculate(AdditionalMatchers.eq(1.0, 0.1))).thenReturn(0.0);
        when(log10.calculate(AdditionalMatchers.eq(1.2, 0.1))).thenReturn(0.0791812);
        when(log10.calculate(AdditionalMatchers.eq(1.5, 0.1))).thenReturn(0.176091);

        return log10;
    }

}
