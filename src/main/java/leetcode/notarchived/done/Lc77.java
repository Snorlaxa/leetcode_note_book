package leetcode.notarchived.done;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: 余子毅
 * @Date: 2021/6/28 18:24
 * @题意: 组合、给定n和k，返回1到n中所有可能的k个数的组合
 */
public class Lc77 {
    public static List<List<Integer>> solution(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(res, deque, n, k, 1);
        return res;
    }

    public static void dfs(List<List<Integer>> res, Deque<Integer> deque, int n, int k, int begin) {
        if (k == 0) {
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = begin; i <= n; i++) {
            deque.addLast(i);
            dfs(res, deque, n, k-1, i + 1);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> solution = solution(4, 4);
        for (List<Integer> arr : solution) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    /**
     * 1 2 3 4
     * 1 2 3
     * 1 2 4
     * 1 3 4
     * 2 3 4
     */
}
