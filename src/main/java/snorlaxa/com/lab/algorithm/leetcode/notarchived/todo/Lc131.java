package snorlaxa.com.lab.algorithm.leetcode.notarchived.todo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: 余子毅
 * @Date: 2021/8/5 9:41
 * @题意: 分割回文串。返回所所有可能组合
 * aabbcc
 */
public class Lc131 {

    private boolean[][] dp;

    public List<List<String>> solution(String s) {
        this.dp = new boolean[s.length()][s.length()];
        // dp定义：表示字符串从i到j位置的子字符串是否为回文串
        // 预处理dp，动态规划复用结果
        // 长度
        for (int i = 0; i < s.length(); i++) {
            // 下标
            for (int j = 0; j + i < s.length(); j++) {
                boolean res = s.charAt(j) == s.charAt(j + i);
                if (i > 1) dp[j][j + i] = res && dp[j + 1][j + i - 1];
                else dp[j][j + i] = res;
            }
        }

        for (boolean[] row : dp) {
            for (boolean b : row) {
                System.out.print(b);
            }
            System.out.println();
        }
        List<List<String>> res = new ArrayList<>();
        Deque<String> deque = new ArrayDeque<>();
        dfs(res, deque, s, 0, s.length() - 1);
        return res;
    }

    /**
     * 深度优先遍历可能的情况
     *
     * @param res
     * @param deque
     * @param s
     * @param start
     * @param end
     */
    public void dfs(List<List<String>> res, Deque<String> deque, String s, int start, int end) {
        if (start > end) {
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i = start; i <= end; i++) {
            if (dp[start][i]) {
                deque.addLast(s.substring(start, i + 1));
                dfs(res, deque, s, i + 1, end);
                deque.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        Lc131 lc131 = new Lc131();
        List<List<String>> solution = lc131.solution("aabbcc");
        solution.forEach(res -> {
            res.forEach(x -> {
                System.out.print(x + " ");
            });
            System.out.println();
        });
    }
}
