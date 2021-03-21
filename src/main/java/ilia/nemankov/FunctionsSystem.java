package ilia.nemankov;

public class FunctionsSystem extends Function {

    private final Function function1;
    private final Function function2;

    public FunctionsSystem(double precision, Function function1, Function function2) {
        super(precision);

        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double calculate(double x) {
        if (x <= 0) {
            return function1.calculate(x);
        } else {
            return function2.calculate(x);
        }
    }

}
