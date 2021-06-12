package leetcode.notarchived.done;

import java.util.*;

/**
 * @Author: 余子毅
 * @Date: 2021/6/10 14:21
 * @题意: 全排列，无重复数据
 */
public class Lc46 {
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] flags = new int[nums.length];
        dfs(nums, flags, res, new ArrayDeque<>(), nums.length);
        return res;
    }

    /**
     * 回溯剪枝
     *
     * @param nums    原数据
     * @param flags   访问标记
     * @param res     结果集
     * @param current 当前队列
     * @param left    剩余数量
     */
    private static void dfs(int[] nums, int[] flags, List<List<Integer>> res, Deque<Integer> current, int left) {
        if (left == 0) {
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (flags[i] != 1) {
                flags[i] = 1;
                current.addLast(nums[i]);
                left--;
                dfs(nums, flags, res, current, left);
                left++;
                current.removeLast();
                flags[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        // [1,2,3]
        // 2->3; 3->2 不能设定起始点，要全部遍历，剔除已访问的
        //
        int[] nums = new int[]{1};
        List<List<Integer>> solution = solution(nums);
        solution.forEach(x -> {
            x.forEach(System.out::print);
            System.out.println();
        });
    }
}
