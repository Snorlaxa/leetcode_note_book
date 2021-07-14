package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: 余子毅
 * @Date: 2021/7/5 9:42
 * @题意: 最长连续序列。给定一个未排序整数数组，找出最长连续序列，不要求在原数组中连续，如 2 3 1 10 4，结果为[1,2,3,4]。要求时间复杂度O(n)
 */
public class Lc128 {
    public static int solution(int[] nums) {
        /**
         * 100 2 101 5 3 4 200 1
         * 如何识别不同的组
         * 100，2，如何判断这两个是不同的组
         * 以每一个元素为起始，判断之后的元素在不在数组里，比如101的后面102不在数组中，说明这个数断档了。
         * 用set来判断数字是否存在，因为是用hash，复杂度O(1)
         * 这样的一个问题是，上述数组中，2会判断4、5存不存在，3也会判断4、5存不存在，是重复判断了的。
         * 判断的依据是，set里是否已经有当前值-1存在，如果x-1存在的话，不论这个x-1在之前还是在之后会遍历到，都会覆盖到x，
         * 因为要以每一个元素为起始向后查找可能的数字，直到某一个数字不存在为止，所以这里选择的是连续序列中最小的那个数作为起始。
         */
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int len = 0;
                while (set.contains(n)) {
                    n++;
                    len++;
                }
                longest = Math.max(len, longest);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        int solution = solution(nums);
        System.out.println(solution);
    }
}
