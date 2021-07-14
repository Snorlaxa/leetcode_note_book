package snorlaxa.com.lab.algorithm.leetcode.cataloged.dynamicProgramming;

/**
 * @Author: Yzy
 * @Date: 2021/1/19 11:22
 * @题意: 有 N 阶楼梯，每次可以上一阶或者两阶，求有多少种上楼梯的方法
 * @题解: N阶楼梯的解法可能会用到N-1阶楼梯的结果，所以可以往动态规划方向去思考。N阶楼梯可以从N-1和N-2走到，所以等于f(N-1)+f(N-2)。由于只跟N-1和N-2有关，可以用两个值来记录，而非整个数组
 * f(n) = f(n-1) + f(n-2)
 */
public class ClimbingStairs {
    public static int solution(int n) {
        if (n <= 2) return n;
        int first = 1, last = 2;
        for (int i = 2; i < n; i++) {
            int temp = first + last;
            first = last;
            last = temp;
        }
        return last;
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
    }
}
