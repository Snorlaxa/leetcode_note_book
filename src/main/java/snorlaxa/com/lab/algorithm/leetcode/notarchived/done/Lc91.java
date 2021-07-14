package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

/**
 * @Author: 余子毅
 * @Date: 2021/6/30 17:07
 * @题意: 解码方法。A->1,B->2,... Z->26,将按照该方式加密的字符串解密，返回解码方法的总数。
 */
public class Lc91 {
    public static int solution(String s) {
        /**
         * 12 ->1 2 | 12
         * 1 1|11=2
         * 1 1 2，11 2，1 12=3 = f[i-2]*2
         * 1 1 2 4|11 2 4|1 12 4| 1 1 24| 11 24=5=f[i-2]+f[i-1]
         * 1 1 2 1 2| 11 2 1 2| 1 12 1 2| 1 1 21 2|11 21 2| 1 1 2 12| 11 2 12|1 12 12| = 7 =f[i-2]+f[i-1]
         * f[i]=f[i-1]+f[i-2]  if(s[i]加入后会增加可解释性) else f[i] = f[i-1]
         * 动态规划
         */
        int[] nums = new int[s.length()];
        if (s.startsWith("0")) return 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - '0';
            if (i == 0) nums[i] = 1;
            else if (i == 1) {
                int before = s.charAt(0) - '0';
                nums[i] = (before == 0 || (cur + 10 * before > 26)) ? 1 : 2;
                if (cur == 0) nums[i] -= 1;
            } else {
                int before = s.charAt(i - 1) - '0';
                nums[i] = (before == 0 || (cur + 10 * before > 26)) ? nums[i - 1] : nums[i - 1] + nums[i - 2];
                if (cur == 0) nums[i] -= nums[i - 1];
            }
        }
        return nums[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(solution("12706"));
        /**
         * 127206
         * 1 =1
         * 1 2 | 12 =2
         * 1 2 7| 12 7| =2
         * 1 2 7 2|12 7 2| =2
         * 1 2 7 2 0|12 7 2 0| 12 7 20| = 1
         */
    }
}
