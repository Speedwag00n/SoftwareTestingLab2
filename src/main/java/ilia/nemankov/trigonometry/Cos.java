package ilia.nemankov.trigonometry;

import ilia.nemankov.Function;
import ilia.nemankov.Utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Math.PI;

public class Cos extends Function {

    public final static int SCALE = 10;

    public Cos(double precision) {
        super(precision);
    }

    @Override
    public double calculate(double x) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            return Double.NaN;
        }

        if (x < -PI || x > PI) {
            x -= ((long) (x / (2 * PI)) + ((x > 0) ? 1 : -1)) * 2 * PI;
        }

        BigDecimal currentValue = new BigDecimal(0, MathContext.UNLIMITED);
        BigDecimal previousValue;
        int iteration = 0;

        do {
            previousValue = currentValue;
            currentValue = currentValue.add((new BigDecimal(-1, MathContext.UNLIMITED).pow(iteration)).
                    multiply((new BigDecimal(x, MathContext.UNLIMITED).pow(2 * iteration))).
                    divide(new BigDecimal(Utils.calculateFactorial(2 * iteration)), SCALE, RoundingMode.HALF_UP));
            iteration++;
        } while (getPrecision() <= currentValue.subtract(previousValue).abs().doubleValue() && iteration < MAX_ITERATIONS);

        return currentValue.setScale(SCALE, RoundingMode.UP).doubleValue();
    }

}
