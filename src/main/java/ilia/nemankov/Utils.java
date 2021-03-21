package ilia.nemankov;

public class Utils {

    public static double calculateFactorial(int n) {
        double result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

}
