package 每日一题;

import java.math.BigDecimal;

public class PI {
    private static final BigDecimal ONE = BigDecimal.ONE;
    private static final BigDecimal TWO = new BigDecimal(2);
    private static final BigDecimal FOUR = new BigDecimal(4);
    private static final BigDecimal FIVE = new BigDecimal(5);
    private static final BigDecimal SIX = new BigDecimal(6);
    private static final BigDecimal EIGHT = new BigDecimal(8);
    private static final BigDecimal SIXTEEN = new BigDecimal(16);
    static BigDecimal calc16dPI(int d) {
        return FOUR.multiply(calc16dSj(d, 1)).add(BigDecimal.valueOf(3)).subtract(TWO.multiply(calc16dSj(d, 4)).divideAndRemainder(ONE)[1]).subtract(calc16dSj(d, 5).divideAndRemainder(ONE)[1]).subtract(calc16dSj(d, 6).divideAndRemainder(ONE)[1]).divideAndRemainder(ONE)[1];
    }

    static BigDecimal calc16dSj(int d, int j) {
        int ACCURACY = d + 10;
        BigDecimal part1 = BigDecimal.ZERO;
        BigDecimal part2 = BigDecimal.ZERO;
        for (int k = 0; k <= d; k++) {
            part1 = part1.add(SIXTEEN.pow(d - k).divideAndRemainder(EIGHT.multiply(BigDecimal.valueOf(k)).add(BigDecimal.valueOf(j)))[1].divide(EIGHT.multiply(BigDecimal.valueOf(k)).add(BigDecimal.valueOf(j)), ACCURACY, BigDecimal.ROUND_HALF_UP));
        }

        for (int k = d + 1; k < ACCURACY; k++) {
            part2 = part2.add(ONE.divide(SIXTEEN.pow(k - d).multiply(EIGHT.multiply(BigDecimal.valueOf(k)).add(BigDecimal.valueOf(j))), ACCURACY, BigDecimal.ROUND_HALF_UP));
        }

        return part1.add(part2);
    }

    public static void main(String[] args) {
        for (int d = 0; d < 100; d++) {
            System.out.println("index of " + (d + 1) + ": " + calc16dPI(d).multiply(SIXTEEN));
        }
    }
}
