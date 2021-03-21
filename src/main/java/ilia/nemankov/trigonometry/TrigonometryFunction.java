package ilia.nemankov.trigonometry;

import ilia.nemankov.Function;

public class TrigonometryFunction extends Function {

    private Cos cos;
    private Csc csc;

    public TrigonometryFunction(double precision) {
        super(precision);

        cos = new Cos(precision);
        csc = new Csc(precision);
    }

    @Override
    public double calculate(double x) {
        return cos.calculate(x) * csc.calculate(x);
    }

}
