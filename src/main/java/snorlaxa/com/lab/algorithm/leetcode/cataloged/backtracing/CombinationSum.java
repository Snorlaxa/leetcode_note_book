package snorlaxa.com.lab.algorithm.leetcode.cataloged.backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Yzy
 * @Date: 2021/2/20 9:43
 * @题意: 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。candidates 中的数字可以无限制重复被选取。
 * @题解: 排序可以帮助剪枝
 */
public class CombinationSum {
    public static List<Integer> currentList = new ArrayList<>();

    public static List<List<Integer>> solution(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        recursion(candidates, target, result);
        return result;
    }

    public static void recursion(int[] candidates, int target, List<List<Integer>> result) {
        for (int candidate : candidates) {
            if (target == 0) {
                result.add(new ArrayList<>(currentList));
                return;
            }
            if (candidate > target) {
                return;
            }
            // push
            currentList.add(candidate);
            recursion(candidates, target - candidate, result);
            // pop，回溯
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {3, 2, 5, 6, 1};
        int target = 6;
        List<List<Integer>> result = solution(candidates, target);
        result.forEach(r -> {
            r.forEach(System.out::print);
            System.out.println();
        });
    }
}
