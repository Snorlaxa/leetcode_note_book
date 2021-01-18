package leetcode.math;

/**
 * @Author: Yzy
 * @Date: 2021/1/18 10:20
 * @题意: 翻转带符号数字，超出Integer.Min~Integer.Max的数据为0
 * @题解: 尽量保证正数和负数统一处理。可以不考虑正负，直接处理，跳出循环的条件为num!=0
 */
public class ReverseInteger {
    public static int solution(int num) {
        long sum = 0;
        while (num != 0) {
            int c = num % 10;
            sum = sum * 10 + c;
            num /= 10;
        }
        sum = (sum >= Integer.MIN_VALUE && sum <= Integer.MAX_VALUE) ? sum : 0;
        return (int) sum;
    }

    public static void main(String[] args) {
        System.out.println(solution(102800));
    }
}
