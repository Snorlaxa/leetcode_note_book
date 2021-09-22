package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

import snorlaxa.com.lab.algorithm.base.TreeNode;

/**
 * @Author: 余子毅
 * @Date: 2021/9/17 10:21
 * @题意: 求根节点到叶子节点数字之和
 */
public class Lc129 {

    private static int sum = 0;

    public static int solution(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private static void dfs(TreeNode root, int head) {
        if (root == null) return;
        int val = head * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += val;
            return;
        }
        dfs(root.left, val);
        dfs(root.right, val);
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{4, 3, 0, 1};
        TreeNode treeNode = TreeNode.fromArray(nums);
        int solution = solution(treeNode);
        System.out.println(solution);
    }

}
