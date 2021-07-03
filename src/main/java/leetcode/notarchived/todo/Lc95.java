package leetcode.notarchived.todo;

import base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: 余子毅
 * @Date: 2021/7/2 9:48
 * @题意: 不同二叉搜索树 2。 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
 * 可以按 任意顺序 返回答案。 1<=n<=8
 */
public class Lc95 {
    public static List<TreeNode> solution(int n) {
        /**
         * 分治法，不断选取新的左子树和右子树
         * 也可以用动态规划，需要把相同树型的树复用到新的数据范围里，比如1-k的各种树形，应用到k+1~2*k
         */
        return generateTrees(1, n);
    }

    private static List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        if (start <= end) {
            // 选取根节点
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftTreeNodes = generateTrees(start, i - 1);
                List<TreeNode> rightTreeNodes = generateTrees(i + 1, end);
                // root与子树拼接
                for (TreeNode leftTreeNode : leftTreeNodes) {
                    for (TreeNode rightTreeNode : rightTreeNodes) {
                        res.add(new TreeNode(i, leftTreeNode, rightTreeNode));
                    }
                }
            }
        } else {
            res.add(null);
        }
        return res;
    }


    public static void main(String[] args) {
        List<TreeNode> solution = solution(4);
        for (TreeNode treeNode : solution) {
            List<Integer> tree = TreeNode.toList(treeNode);
            String collect = tree.stream().map(String::valueOf).collect(Collectors.joining(","));
            System.out.println("[" + collect + "]");
        }
    }
}
