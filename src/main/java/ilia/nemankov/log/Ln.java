package ilia.nemankov.log;

import ilia.nemankov.Function;

public class Ln extends Function {

    public Ln(double precision) {
        super(precision);
    }

    @Override
    public double calculate(double x) {
        if (Double.isNaN(x) || x < 0.0) {
            return Double.NaN;
        } else if (x == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        } else if (x == 0.0) {
            return Double.NEGATIVE_INFINITY;
        }

        double currentValue = 0;
        double previousValue;
        int iteration = 1;

        if (Math.abs(x - 1) <= 1) {
            do {
                previousValue = currentValue;
                currentValue += ((Math.pow(-1, iteration - 1) * Math.pow(x - 1, iteration)) / iteration);
                iteration++;
            } while (getPrecision() <= Math.abs(currentValue - previousValue) && iteration < MAX_ITERATIONS);
        } else {
            do {
                previousValue = currentValue;
                currentValue += ((Math.pow(-1, iteration - 1) * Math.pow(x - 1, -iteration)) / iteration);
                iteration++;
            } while (getPrecision() <= Math.abs(currentValue - previousValue) && iteration < MAX_ITERATIONS);

            currentValue += calculate(x - 1);
        }

        return currentValue;
    }
}
