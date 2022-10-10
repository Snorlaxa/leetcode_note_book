package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc100to199;

import java.util.*;

/**
 * @Author: 余子毅
 * @Date: 2021/9/8 16:18
 * @题解: 单词拆分。能否用字典中的单词拆分句子
 */
public class Lc139 {

    /**
     * 回溯+记忆化搜索，主要是为了避免使用substring带来的额外消耗。用startWith或者indexOf的方式来判断字符串是否在字典中。
     *
     * @param s        字符串
     * @param wordDict 字典
     * @return 是否可分割
     */
    public static boolean solution(String s, List<String> wordDict) {
        // 对s来说，从i到i+1的检测是一个阶段，状态是能或者不能拆分，下一阶段能否从上一阶段获得新状态？
        // 递归+记忆化
        /**
         * 01 12 23 34 45 56
         * 02 23 34 45 56
         * 03
         */
        if (s.length() == 0) return false;
        // 定义：长度为i的字符串是否能拆分
        // 采用的是包装类，包装类有三种状态，null、true、false，所以可以表示这种状态是否被遍历过
        Boolean[] dp = new Boolean[s.length()];
        return dfs(s, 0, wordDict, dp);
    }

    // 通过dfs避免substring
    private static boolean dfs(String s, int offset, List<String> wordDict, Boolean[] dp) {
        if (offset == s.length()) return true;

        if (dp[offset] == null) {
            boolean res = false;
            for (String word : wordDict) {
                if (s.startsWith(word, offset) && dfs(s, offset + word.length(), wordDict, dp)) {
                    res = true;
                    break;
                }
            }
            dp[offset] = res;
        }
        return dp[offset];
    }

    /**
     * 动态规划
     * 通过动态规划的方式记录长度为i的字符串是否可拆分，需要用到substring，内部会复制数组，复杂度O(e)
     *
     * @param s        字符串
     * @param wordDict 字典
     * @return 是否可分割
     */
    public static boolean solution2(String s, List<String> wordDict) {
        // 对s来说，从i到i+1的检测是一个阶段，状态是能或者不能拆分，下一阶段能否从上一阶段获得新状态？
        // [i,j]的状态需要通过每一个[i,k][k,j]的组合判断是否
        // [0,j] => [0,k]+contain([k+1,j])
        // 定义：dp[i]长度为i的字符串是否能被拆分（相当于把题目换了个说法，把固定的字符串长度变成了不确定的i）
        HashSet<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            // 只要中间有一种分割方案就是可以被分割
            for (int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                if (dp[j] && wordSet.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcodeleet";
        String[] words = new String[]{"leet", "code", "apple"};
        List<String> wordDict = Arrays.asList(words);
        boolean res = solution(s, wordDict);
        System.out.println(res);
    }
}
