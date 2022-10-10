package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc0to99;

import snorlaxa.com.lab.algorithm.base.TreeNode;

import java.util.List;

/**
 * @Author: 余子毅
 * @Date: 2021/7/7 10:14
 * @题意: 恢复二叉树。二叉搜索树中两个节点被错误的交换，需要恢复这棵树。
 */
public class Lc99 {
    static TreeNode pre = null;
    static TreeNode node = null;
    static TreeNode minNode = null;

    public static void solution(TreeNode root) {
        /**
         *
         * 找到中序遍历出错的位置，根前驱指针交换，使得中序遍历保持严格升序
         */
        if (root == null) return;
        dfs(root);
        if(node!=null&&minNode!=null){
            int tmp = node.val;
            node.val = minNode.val;
            minNode.val = tmp;
        }
    }

    private static void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (pre != null && root.val <= pre.val) {
            if (node == null) {
                // 找到出错的节点1
                node = pre;
                minNode = root;
            } else {
                // 找到出错的节点2，最小的节点
                if (root.val < minNode.val) {
                    minNode = root;
                }
            }
        }
        pre = root;
        dfs(root.right);
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3, 1, 4, null, null, 2};
        TreeNode treeNode = TreeNode.fromArray(nums);
        solution(treeNode);
        List<Integer> list = TreeNode.toList(treeNode);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
    }
}
