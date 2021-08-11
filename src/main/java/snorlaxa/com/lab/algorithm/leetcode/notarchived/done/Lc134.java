package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

/**
 * @Author: 余子毅
 * @Date: 2021/8/9 9:09
 * @题意: 加油站。环形公路上N个加油站，第i个加油站有gas[i]汽油，到下一个加油站的消耗是cost[i]，从哪个加油站开始可以绕环形公路一圈，无则返回-1
 */
public class Lc134 {
    public static int solution(int[] gas, int[] cost) {
        /**
         * gas:1,2,3,4,5
         * cost:3,4,5,1,2
         * 利用匹配失败的信息来否决某些方案
         * 如果从某个加油站走到另一个加油站时没有汽油往下走，则这中间经过的所有加油站都不能作为起始点，因为从最开始的加油站往下走是这中间剩余最多的，依然走不完环形
         */
        for (int i = 0; i < gas.length; ) {
            if (gas[i] >= cost[i]) {
                // 能走到下一个加油站
                int res = gas[i] - cost[i];
                int j = i + 1;
                while (j % gas.length != i) {
                    res += gas[j % gas.length];
                    //往下一个加油站走
                    res -= cost[j % gas.length];
                    if (res < 0) break;
                    j++;
                }
                if (res >= 0) return i;
                else i = j;
            } else i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = new int[]{2, 3, 4};
        int[] cost = new int[]{3, 4, 3};
        System.out.println(solution(gas, cost));
    }
}
