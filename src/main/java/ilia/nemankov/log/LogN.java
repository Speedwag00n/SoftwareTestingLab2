package ilia.nemankov.log;

import ilia.nemankov.FunctionWithBase;

public class LogN extends FunctionWithBase {

    private Ln ln;

    public LogN(double precision, int base) {
        super(precision, base);
        ln = new Ln(precision);
    }

    @Override
    public double calculate(double x) {
        if (getBase() <= 0 || getBase() == 1) {
            return Double.NaN;
        }

        return ln.calculate(x) / ln.calculate(getBase());
    }

    @Override
    public void setPrecision(double precision){
        super.setPrecision(precision);
        ln.setPrecision(precision);
    }
}
