package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

import snorlaxa.com.lab.algorithm.base.TreeNode;

import java.util.*;

/**
 * @Author: 余子毅
 * @Date: 2021/7/18 10:58
 * @题解: 二叉树的层序遍历II。 从底层向上遍历，如：
 * [ 3 ]
 * [ 9 20 ]
 * [ null null 15 7 ]
 * 从底层向上遍历：
 * [15 7]
 * [9 20]
 * [3]
 */
public class Lc107 {
    /**
     * 将倒序列表的操作转变为链表头插法，省去倒序的操作
     *
     * @param root root
     * @return res
     */
    public static List<List<Integer>> solution1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
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
            res.add(0, step);
        }
        return res;
    }

    /**
     * 利用递归把结果倒序存入res
     *
     * @return res
     */
    public static List<List<Integer>> solution2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        recursion(deque, res);
        return res;
    }

    public static void recursion(Deque<TreeNode> deque, List<List<Integer>> res) {
        if (deque.isEmpty()) return;
        int n = deque.size();
        List<Integer> step = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            TreeNode treeNode = deque.poll();
            step.add(treeNode.val);
            if (treeNode.left != null) deque.offer(treeNode.left);
            if (treeNode.right != null) deque.offer(treeNode.right);
        }
        recursion(deque, res);
        res.add(step);
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3, 9, 20, null, null, 15, 7};
        TreeNode treeNode = TreeNode.fromArray(nums);
        List<List<Integer>> solution = solution2(treeNode);
        solution.forEach(x -> {
            System.out.print("[ ");
            x.forEach(n -> {
                System.out.print(n + " ");
            });
            System.out.println(" ]");
        });
    }
}
