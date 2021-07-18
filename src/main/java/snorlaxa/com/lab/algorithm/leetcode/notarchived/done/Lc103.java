package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

import snorlaxa.com.lab.algorithm.base.TreeNode;

import java.util.*;

/**
 * @Author: 余子毅
 * @Date: 2021/7/16 9:39
 * @题意: 二叉树的锯齿形层序遍历
 */
public class Lc103 {
    public static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        boolean turn = false;
        while (!deque.isEmpty()) {
            int n = deque.size();
            List<Integer> step = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = deque.poll();
                if (turn) {
                    step.add(0, treeNode.val);
                } else {
                    step.add(treeNode.val);
                }
                if (treeNode.left != null) deque.offer(treeNode.left);
                if (treeNode.right != null) deque.offer(treeNode.right);
            }
            turn = !turn;
            res.add(step);
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3, 9, 20, 7, 5, 15, 10,null,null,12,29,34,8};
        TreeNode treeNode = TreeNode.fromArray(nums);
        TreeNode.print(treeNode);
        List<List<Integer>> solution = solution(treeNode);
        solution.forEach(x -> {
            System.out.print("[ ");
            x.forEach(n -> {
                System.out.print(n + " ");
            });
            System.out.println(" ]");
        });
    }
}
