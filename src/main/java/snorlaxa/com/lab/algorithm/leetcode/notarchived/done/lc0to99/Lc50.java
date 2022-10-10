package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc0to99;

/**
 * @Author: 余子毅
 * @Date: 2021/6/10 17:03
 * @题意: 实现Power(x, n) x^n
 */
public class Lc50 {
    public static double solution(double x, int n) {
        if (x == 0) return x;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        return n < 0 ? 1.0 / pow(x, -1 * (long) n) : pow(x, n);
    }

    private static double pow(double x, long n) {
        if (n <= 0) return 1.0;
        if (n == 1) return x;
        if (n == 2) return x * x;
        long m = n / 2;
        long r = n % 2;
        double rx = r > 0 ? x : 1.0;
        return pow(x * x, m) * rx;
    }

    public static void main(String[] args) {
        /**
         * 2*2 2*2 2*2 => 4*4 *4=>16*4=>64
         */
        System.out.println(solution(2.00000, -2147483648));
    }
}
