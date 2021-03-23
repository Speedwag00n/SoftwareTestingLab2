package ilia.nemankov;

public abstract class Function {

    public static final int MAX_ITERATIONS = 1000000;
    public static final double DELTA = 1e-4;

    private double precision;

    protected Function(double precision) {
        this.precision = precision;
    }

    public double getPrecision() {
        return precision;
    }

    public abstract double calculate(double x);

}
