package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc200to299;

/**
 * @author Yzy
 * @version 1.0
 * Date: 2023/11/3 17:40
 */
public class Lc263 {
    public static boolean isUgly(int n) {
        if (n < 0) n = -n;// todo 防止溢出
        if (n <= 3)
            return true;

        boolean res = false;
        while (n % 2 == 0) {
            n = n >> 1;
        }
        if (n % 5 == 0) {
            res = isUgly(n / 5);
        }
        if (n % 3 == 0 && !res) {
            res = isUgly(n / 3);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(isUgly(-2147483648));
    }
}
