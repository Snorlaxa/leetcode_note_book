package snorlaxa.com.lab.algorithm.leetcode.notarchived.todo;

import java.util.*;

/**
 * @Author: 余子毅
 * @Date: 2021/9/8 16:18
 * @题解: 单词拆分。能否用字典中的单词拆分句子
 */
public class Lc139 {
    private static Set<String> wordSet;
    private static boolean[] dp;

    public static boolean solution(String s, List<String> wordDict) {
        // 对s来说，从i到i+1的检测是一个阶段，状态是能或者不能拆分，下一阶段能否从上一阶段获得新状态？
        // 回溯+记忆化
        /**
         * 01 12 23 34 45 56
         * 02 23 34 45 56
         * 03
         */
        if (s.length() == 0) return false;
        wordSet = new HashSet<>(wordDict);
        dp = new boolean[s.length() + 1];
        return dfs(s, 0, s.length() - 1);
    }


    private static boolean dfs(String s, int start, int end) {
        if (start >= end) return true;
        for (int i = start; i <= end; i++) {
            String word = s.substring(start, i + 1);
            System.out.println(word);
            if (wordSet.contains(word) && dfs(s, i + 1, end)) {
                return true;
            }
        }
        return false;
    }


    public static boolean solution2(String s, List<String> wordDict) {
        // 对s来说，从i到i+1的检测是一个阶段，状态是能或者不能拆分，下一阶段能否从上一阶段获得新状态？
        // [i,j]的状态需要通过每一个[i,k][k,j]的组合判断是否
        wordSet = new HashSet<>(wordDict);
        dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (dp[j] && wordSet.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "leetcodeleet";
        String[] words = new String[]{"leet", "code", "apple"};
        List<String> wordDict = Arrays.asList(words);
        boolean res = solution2(s, wordDict);
        System.out.println(res);
    }
}
