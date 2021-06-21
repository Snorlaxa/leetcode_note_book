package leetcode.cataloged.math;

/**
 * @Author: Yzy
 * @Date: 2021/3/15 9:31
 * @题意: 实现除法，不能使用乘法、除法，溢出时采用Integer.MAX_VALUE和Integer.MIN_VALUE替代
 * @题解: 25/4=> 4<<2<25 and 4<<3>25,25-4*4=9 => 9/4=? => 4<<1<9 and 4<<2>9,9-4*2=1 => 1<4 终止，得到2+1=3，所以25/4=3
 * 关于溢出的处理。一、在计算前对特殊值如1，-1等做讨论；二、负数的范围比正数大，所以全部转换成负数来做，就不会有结果溢出的情况；
 * 三、中途计算时除数左移可能存在溢出，需要做判断【判断后续步骤是否会溢出的办法，可以用MIN_VALUE或者MAX_VALUE做反向的操作与原值做比较】
 */
public class DivideTwoNumber {
    public static int solution(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (divisor == 1) return dividend;
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
            return -dividend;
        }

        // 通过异或判断结果正负
        int flag = ((dividend ^ divisor) < 0) ? -1 : 1;

        // 负数的范围比正数大，全部转换成负数处理
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        return flag > 0 ? recursion(dividend, divisor) : -recursion(dividend, divisor);
    }

    public static int recursion(int dividend, int divisor) {
        //终止条件
        if (dividend > divisor) {
            return 0;
        }
        int result = dividend, i = 0, sum = 0;
        while (true) {
            // 预先用最小值MIN_VALUE右移相同的位数，与除数作比较，来判断除数左移时是否可能会溢出
            int temp = (divisor < Integer.MIN_VALUE >> i) ? Integer.MIN_VALUE : divisor << i;
            if (result > temp) {
                break;
            }
            result -= divisor << i;
            sum += 1 << i++;
        }
        return sum + recursion(result, divisor);
    }

    public static void main(String[] args) {
        System.out.println(solution(-10, 3));
    }

}
