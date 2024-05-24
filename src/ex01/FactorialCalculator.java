package ex01;

import java.math.BigDecimal;

public class FactorialCalculator {
    public BigDecimal calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("O número deve ser não negativo.");
        }
        BigDecimal result = BigDecimal.ONE;
        for (int i = 1; i <= number; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }
        return result;
    }
}