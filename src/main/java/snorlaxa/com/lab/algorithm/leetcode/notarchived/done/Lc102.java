package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

import snorlaxa.com.lab.algorithm.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: 余子毅
 * @Date: 2021/7/15 16:58
 * @题意: 二叉树的层序遍历
 */
public class Lc102 {
    public static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int n = deque.size();
            List<Integer> step = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = deque.poll();
                step.add(treeNode.val);
                if (treeNode.left != null) deque.offer(treeNode.left);
                if (treeNode.right != null) deque.offer(treeNode.right);
            }
            res.add(step);
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeNode.fromArray(nums);
        List<List<Integer>> solution = solution(treeNode);
        solution.forEach(x->{
            System.out.print("[ ");
            x.forEach(n->{
                System.out.print(n+" ");
            });
            System.out.println(" ]");
        });
    }
}
