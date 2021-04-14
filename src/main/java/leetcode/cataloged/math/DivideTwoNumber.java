package leetcode.cataloged.math;

/**
 * @Author: Yzy
 * @Date: 2021/3/15 9:31
 * @题意: 实现除法，不能使用乘法、除法，溢出时采用Integer.MAX_VALUE和Integer.MIN_VALUE替代
 * @题解: 25/4=> 4>>2<25 and 4>>3>25,25-4*4=9 => 9/4=? => 4>>1<9 and 4>>2>9,9-4*2=1 => 1<4 终止，得到2+1=3，所以25/4=3
 *  关于溢出的处理
 */
public class DivideTwoNumber {
    public int solution(int num){
        return 0;
    }
}
