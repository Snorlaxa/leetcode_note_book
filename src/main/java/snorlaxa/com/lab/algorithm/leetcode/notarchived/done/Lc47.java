package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

import java.util.*;

/**
 * @Author: 余子毅
 * @Date: 2021/6/10 14:54
 * @题解: 全排列2，数据存在重复，需要去重
 * 这种排除可以用两种方式，一种直接排除与前面元素相同的起始元素，但不好操作；
 * 另一种是规定访问的顺序，比如[1',1,3]在以1‘为起始的查找中，如果1’被访问了，而遇到了1，则跳过本次查找；
 * 等以1为起始，访问到1'时则不跳过，也就是剪枝掉了 1' 1 3这个结果。
 * 方案1比方案2的剪枝效果好，因为直接去除了整个路线。
 * <p>方案1的实现思路：</p>
 */
public class Lc47 {
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
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
            // 当前一个元素深度遍历完成后，以第一个元素开始的排列都写入了，如果后续再以相同的元素开始，结果也是相同的，
            // 所以遇到与前一个元素相同的数据应当排除
            // if (i > 0 && nums[i - 1] == nums[i] && flags[i - 1] == 1) continue;
            // 进行层级剪枝，如果之前的元素flag=0，说明以前一相同元素为起始的序列已经访问完，并且以第二个相同元素为起始，直接剪枝掉该搜索序列
            if (i > 0 && nums[i - 1] == nums[i] && flags[i - 1] == 0) continue;
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
        // [1',1,3]
        // 1' 1 3-> 1' 3 1 -> 1 1' 3
        // 1' 3 1-> 1 3 1'
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> solution = solution(nums);
        solution.forEach(x -> {
            x.forEach(System.out::print);
            System.out.println();
        });
    }
}
