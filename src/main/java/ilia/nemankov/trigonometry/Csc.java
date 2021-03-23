package ilia.nemankov.trigonometry;

import ilia.nemankov.Function;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Math.PI;

public class Csc extends Function  {

    public final static int MIN_SCALE = 10;

    private Cos cos;

    public Csc(double precision) {
        super(precision);
        cos = new Cos(precision);
    }

    public void setCos(Cos cos) {
        this.cos = cos;
    }

    @Override
    public double calculate(double x) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            return Double.NaN;
        }

        if (Math.abs(x % PI) < getPrecision()) {
            return Double.NaN;
        }

        if (x < -PI || x > PI) {
            x -= ((long) (x / (2 * PI)) + ((x > 0) ? 1 : -1)) * 2 * PI;
        }

        double cosine = cos.calculate(x);

        BigDecimal currentValue = new BigDecimal(0, MathContext.UNLIMITED);
        BigDecimal previousValue;
        int iteration = MIN_SCALE;

        do {
            previousValue = currentValue;
            currentValue = sqrt(
                    new BigDecimal(1, MathContext.UNLIMITED)
                            .divide(new BigDecimal(1, MathContext.UNLIMITED)
                            .subtract(new BigDecimal(cosine * cosine, MathContext.UNLIMITED)), iteration, RoundingMode.UP),
                    iteration
            );
            iteration++;
        } while (getPrecision() <= currentValue.subtract(previousValue).abs().doubleValue() && iteration < MAX_ITERATIONS);

        double result = currentValue.setScale(iteration, RoundingMode.UP).doubleValue();

        if (x >= 0) {
            return result;
        } else {
            return -result;
        }
    }

    private BigDecimal sqrt(BigDecimal value, final int scale) {
        BigDecimal x0 = BigDecimal.ZERO;
        BigDecimal x1 = new BigDecimal(Math.sqrt(value.doubleValue()));

        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = value.divide(x0, scale, BigDecimal.ROUND_HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(new BigDecimal(2), scale, BigDecimal.ROUND_HALF_UP);
        }

        return x1;
    }

}
