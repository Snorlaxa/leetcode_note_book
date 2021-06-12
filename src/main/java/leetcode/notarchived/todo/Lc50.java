package leetcode.notarchived.todo;

import java.math.BigDecimal;

/**
 * @Author: 余子毅
 * @Date: 2021/6/10 17:03
 * @题意: 实现Power(x, n) x^n
 */
public class Lc50 {
    public static double solution(double x, int n) {
        // 暴力方法：x*x*x....x n个x相乘
        // 其中乘积的结果可以复用，如2*2=4,4*4=16,就得到2^4
        // 如何选择复用的乘积和复用的次数是关键
        /**
         * 假设最终结果等于m，则m=x*x*...x=pow(x,A)*pow(x,A)*pow(x,B)*pow(x,B)...
         * 如何找到合适的A,B,C...
         * pow(x,2)*pow(x,2)=pow(x,4)
         * 2 4 8 16 ->n
         * 找小于n的最大2的次方，然后剩余的按同样的方式求pow
         */
        if (x == 0) return x;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1 / x;
        int flag = 1;
        if (n < 0) flag = -1 * flag;
        double res = pow(BigDecimal.valueOf(x), flag * n).doubleValue();
        return flag < 0 ? 1 / res : res;
    }

    private static BigDecimal pow(BigDecimal x, int n) {
        if (n <= 0) return BigDecimal.valueOf(1.0);
        if (n == 1) return x;
        if (n == 2) return x.multiply(x);
        int rightn = find(n);
        BigDecimal leftres = BigDecimal.valueOf(1);
        BigDecimal rightres = pow(x, rightn);
        if (n - rightn > 0) {
            int left = find(n - rightn);
            leftres = pow(x, left);
        }
        return rightres.multiply(leftres);
    }

    private static int find(int n) {
        if (n < 2) return 0;
        int i = 0;
        while (i < n && (1 << ++i) < n) ;
        return i - 1;
    }


    public static void main(String[] args) {
        /**
         * 2*2 2*2 2*2 => 4*4 *4=>16*4=>64
         */
        System.out.println(solution(2, 6));
    }
}
