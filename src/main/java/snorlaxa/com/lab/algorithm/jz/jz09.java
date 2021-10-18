package snorlaxa.com.lab.algorithm.jz;

/**
 * @Author: 余子毅
 * @Date: 2021/10/8 13:40
 * @题意: 跳台阶，一次可跳1到n级，跳上n级台阶有多少种方法
 */
public class jz09 {
    public static int solution(int n) {
        /**
         * 1-n fn
         * n->n+1 经过n:fn，不经过n：fn
         * 1-2 1
         * 1-3 1+1=2
         * 1-4 1+2+1=4
         * 1-5 8 1 2 3 4 5 1+2+4+1=8
         *
         * 状态定义：fn = 从1跳到n的方法种类
         * 状态转移：fn = f(n-1)+f(n-2)+f(n-3)...f(2)
         * f(n-1)=f(n-2)...f(2)
         * fn=2f(n-1)
         * f(n-1)=2f(n-2)
         * f(3)=2f(2)
         * fn = 2^(n-2)*1
         */
        return n > 1 ? (int) Math.pow(2, n - 2) : 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(1));
    }
}
