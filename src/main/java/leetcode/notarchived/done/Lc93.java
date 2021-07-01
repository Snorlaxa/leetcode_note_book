package leetcode.notarchived.done;

import java.util.*;

/**
 * @Author: 余子毅
 * @Date: 2021/7/1 14:13
 * @题意: 复原IP地址。给一串数字组成的字符串，给出所有可能的ip地址。注意不能包含前导0.
 */
public class Lc93 {
    public static List<String> solution(String s) {
        /**
         * 25525511135
         * 2.552 xx 11-1=10 >9 用不完数字了
         * 25.525 xx 11-2=9 525大于255，无效
         * 255.2.5 xx 11-3=8 8-1=7>3*2 用不完数字了
         * 255.25.511
         * （相等的值跳过，由于是字符串，可以用hash去重）
         */
        if (s.length() > 12 || s.length() < 4) return new ArrayList<>();
        Set<String> res = new HashSet<>();
        dfs(res, s, new ArrayDeque<>(), 4, 0);
        return new ArrayList<>(res);
    }

    private static void dfs(Set<String> res, String s, Deque<String> deque, int restPartNum, int begin) {
        if (restPartNum == 0) {
            res.add(String.join(".", deque));
            return;
        }
        for (int j = 1; j <= 3; j++) {
            if (begin + j > s.length()) break;
            String numstr = s.substring(begin, begin + j);
            if ((restPartNum - 1) * 3 < s.length() - begin - j) continue;
            if (j > 1 && numstr.startsWith("0")) break;
            int num = Integer.parseInt(numstr);
            if (num > 255) break;

            deque.addLast(numstr);
            // 可以作为起始
            dfs(res, s, deque, restPartNum - 1, begin + j);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        String s = "0";
        List<String> solution = solution(s);
        for (String r : solution) {
            System.out.println(r);
        }
    }
}
