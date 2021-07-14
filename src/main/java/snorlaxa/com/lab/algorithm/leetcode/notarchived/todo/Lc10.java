package snorlaxa.com.lab.algorithm.leetcode.notarchived.todo;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: 余子毅
 * @Date: 2021/6/24 9:44
 * @题意: 正则表达式匹配。支持.，*语法
 * ccaaba c*a*b*p*
 */
public class Lc10 {
    public static boolean solution(String s, String p) {
        if (s.length() == 0 || p.length() == 0) return false;
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < p.length(); i++) deque.offer(p.charAt(i));

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Character curr = deque.poll();
            if (curr == null) return false;

            if (curr.equals(c) || curr.equals('.')) {
                // 如果匹配，应该看后续*存不存在，存在则放回队首
                if (deque.isEmpty()) return true;

                if (deque.peekFirst().equals('*')) {
                    // 当与后面的数据匹配时不需要放回
                    deque.push(curr);
                }
            } else if (deque.isEmpty() || !deque.peekFirst().equals('*')) {
                return false;
            } else {
                // 匹配到*，跳过并与下一个匹配
                deque.poll();
                i--;
            }
        }

        // 到达末尾，判断剩余的是否能匹配空
        while (!deque.isEmpty()) {
            Character c = deque.poll();
            if (!c.equals('.') && !c.equals('*'))
                if (deque.isEmpty() || !deque.peekFirst().equals('*')) return false;
        }

        return true;
    }

    public static boolean solution2(String s, String p) {
        if (s.length() == 0 || p.length() == 0) return false;
        int i, j = 0;
        boolean allMatchFlag = false;
        for (i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (j >= p.length()) return false;
            char curr = p.charAt(j);
            j++;

            if (curr == c) {
                // 如果匹配，应该看后续*存不存在，存在则放回队首
                if (j >= p.length()) return i + 1 >= s.length();
                if (p.charAt(j) == '*') {
                    j--;
                }
                allMatchFlag = false;
            } else if (curr == '.') {
                if (p.charAt(j) == '*') {
                    allMatchFlag = true;
                    j++;
                }
            } else if (j < p.length() && !(p.charAt(j) == '*')) {
                // 超出范围或者
                if (!allMatchFlag) return false;
            } else if (allMatchFlag) {
                // 未匹配，且还在.*的影响范围内
                j--;
            } else {
                // 未匹配，但后面带*的，跳过本次匹配并保留当前字符
                i--;
                j++;
            }
        }

        // 到达末尾，判断剩余的是否能匹配空
        while (j < p.length()) {
            char c = p.charAt(j++);
            if (!(c == '*'))
                if (j >= p.length() || !(p.charAt(j) == '*')) return false;
        }

        return true;
    }

    /**
     * 动态规划
     * @param s 目标
     * @param p pattern
     * @return 是否匹配
     */
    public static boolean solution3(String s, String p) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution2("kiiibc", "k..*a*bc") ? "是" : "否");
    }
}
