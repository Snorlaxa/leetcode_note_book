package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc100to199;

public class Lc172 {
    public static int trailingZeroes(int n) {
        //二分求5相乘的最大个数
        int l = 1, r = n / 5;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            int pow = (int) Math.pow(5, mid);
            if (pow <= n) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int res = 0;
        while (r > 0) res += (n / (int) Math.pow(5, r--)); // 1*5 有一个0， 1*5*5 有两个0，需要再加一个0
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(26));
    }
}
