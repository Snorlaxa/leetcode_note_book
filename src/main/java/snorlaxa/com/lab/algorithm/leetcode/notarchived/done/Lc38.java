package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

/**
 * @Author: 余子毅
 * @Date: 2021/6/7 13:37
 * @题意: 外观数组
 */
public class Lc38 {
    public static String solution(int n) {
        if (n == 1) return "1";
        String current = "1";
        for (int i = 2; i <= n; i++) {
            current = count(current);
        }
        return current;
    }

    private static String count(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            char c = str.charAt(i);
            while (++i < str.length() && str.charAt(i - 1) == str.charAt(i)) count++;
            i--;
            stringBuilder.append(count).append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String count = solution(5);
        System.out.println(count);
    }
}
