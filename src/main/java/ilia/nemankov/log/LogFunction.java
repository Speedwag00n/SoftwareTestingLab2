package ilia.nemankov.log;

import ilia.nemankov.Function;

public class LogFunction extends Function {

    private Ln ln;
    private Log2 log2;
    private Log5 log5;
    private Log10 log10;

    public LogFunction(double precision) {
        super(precision);

        ln = new Ln(precision);
        log2 = new Log2(precision);
        log5 = new Log5(precision);
        log10 = new Log10(precision);
    }

    @Override
    public double calculate(double x) {
        return (((((log10.calculate(x) + log10.calculate(x)) - log5.calculate(x)) + ln.calculate(x)) - (log5.calculate(x) - log2.calculate(x)))
                * (((log10.calculate(x) * log10.calculate(x)) + log5.calculate(x)) - log2.calculate(x)));
    }

    public void setLn(Ln ln) {
        this.ln = ln;
    }

    public void setLog2(Log2 log2) {
        this.log2 = log2;
    }

    public void setLog5(Log5 log5) {
        this.log5 = log5;
    }

    public void setLog10(Log10 log10) {
        this.log10 = log10;
    }
}
