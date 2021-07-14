package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: 余子毅
 * @Date: 2021/6/30 16:48
 * @题解: 子集2.给一个整数数组，可能存在重复数据，返回无重复结果的全部子集。
 */
public class Lc90 {
    public static List<List<Integer>> solution(int[] nums) {
        // 排序将重复数据放在一起
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(res, deque, nums, 0);
        return res;
    }

    /**
     * @param res   结果集
     * @param deque 双端队列，用于存储当前结果
     * @param nums  原始数组
     * @param begin 搜索起始位置
     */
    private static void dfs(List<List<Integer>> res, Deque<Integer> deque, int[] nums, int begin) {
        res.add(new ArrayList<>(deque));

        for (int i = begin; i < nums.length; i++) {
            // 剪枝，去除重复
            // 以前一个数据为起始的搜索序列已经搜索完成，此时无需再以相同数据为起始进行搜索
            if (i > begin && nums[i] == nums[i - 1])
                continue;

            deque.addLast(nums[i]);
            dfs(res, deque, nums, i + 1);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2};
        List<List<Integer>> solution = solution(nums);
        for (List<Integer> arr : solution) {
            System.out.print("[");
            String collect = arr.stream().map(String::valueOf).collect(Collectors.joining(","));
            System.out.print(collect);
            System.out.println("]");
        }
    }
}
