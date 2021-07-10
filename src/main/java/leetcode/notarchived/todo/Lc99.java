package leetcode.notarchived.todo;

import base.TreeNode;

import java.util.List;

/**
 * @Author: 余子毅
 * @Date: 2021/7/7 10:14
 * @题意: 恢复二叉树。二叉搜索树中两个节点被错误的交换，需要恢复这棵树。
 */
public class Lc99 {
    public static void solution(TreeNode root) {
        /**
         *   4
         * 1    8
         *     5  10
         *       7
         * 找到中序遍历出错的位置，根前驱指针交换
         */
        dfs(root, null);
    }

    private static void dfs(TreeNode root, TreeNode pre) {
        if (root == null) return;
        dfs(root.left, pre);
        if (pre != null && root.val <= pre.val) {
            // 交换两个节点的值
            int tmp = pre.val;
            pre.val = root.val;
            root.val = tmp;
            return;
        }
        pre = root;
        dfs(root.right, pre);
    }

    public static void main(String[] args) {
        Integer[] nums  = new Integer[]{3,1,4,null,null,2};
        TreeNode treeNode = TreeNode.fromArray(nums);
        solution(treeNode);
        List<Integer> list = TreeNode.toList(treeNode);
        for (Integer i : list) {
            System.out.print(i+" ");
        }
    }
}
