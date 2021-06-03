package leetcode.notarchived.todo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 余子毅
 * @Date: 2021/5/24 9:40
 * @题意: 组合总和, 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates = [2,3,6,7], target = 7
 * [
 * [7],
 * [2,2,3]
 * ]
 * @题解: 回溯剪枝
 */
public class Lc39 {
    public static List<List<Integer>> solution(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(res, current, nums, target,0);
    }

    private static void dfs(List<List<Integer>> res, List<Integer> current, int[] nums, int target,int sum) {
        for (int i = 0; i < nums.length; i++) {

        }
    }

    public static void main(String[] args) {

    }
}
