package snorlaxa.com.lab.algorithm.leetcode.notarchived.todo;

import snorlaxa.com.lab.algorithm.base.TreeNode;

/**
 * @Author: 余子毅
 * @Date: 2021/7/21 22:33
 * @题意: 将有序数组转换为二叉搜索树。给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 */
public class Lc108 {
    int[] nums;

    public static TreeNode solution(int[] nums) {
        return new Lc108().buildTree(nums);
    }

    public TreeNode buildTree(int[] nums) {
        this.nums = nums;
        return buildTree(0, nums.length - 1);
    }

    private TreeNode buildTree(int start, int end) {
        if (start > end) return null;
        int mid = start + end >> 1;
        TreeNode left = buildTree(start, mid - 1);
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = left;
        treeNode.right = buildTree(mid + 1, end);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode solution = solution(nums);
        TreeNode.print(solution);
    }
}
