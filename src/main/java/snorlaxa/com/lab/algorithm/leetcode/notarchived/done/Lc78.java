package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: 余子毅
 * @Date: 2021/6/28 22:22
 * @题意: 子集。给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 */
public class Lc78 {
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i <= nums.length; i++) {
            dfs(res, deque, nums, 0, i);
            deque.clear();
        }
        return res;
    }

    private static void dfs(List<List<Integer>> res, Deque<Integer> deque, int[] nums, int begin, int k) {
        if (k == 0) {
            res.add(new ArrayList<>(deque));
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            deque.addLast(nums[i]);
            dfs(res, deque, nums, i + 1, k - 1);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        List<List<Integer>> solution = solution(nums);
        for (List<Integer> arr : solution) {
            for (Integer i : arr) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
