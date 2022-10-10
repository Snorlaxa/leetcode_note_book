package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc100to199;

import snorlaxa.com.lab.algorithm.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 余子毅
 * @Date: 2021/7/15 9:27
 * @题解: 从中序与后序遍历序列构造二叉树
 */
public class Lc106 {
    int[] postorder;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public static TreeNode solution(int[] inorder, int[] postorder) {
        Lc106 solution = new Lc106();
        return solution.buildTree(inorder, postorder);
    }


    private TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        for (int i = 0; i < inorder.length; i++) inorderMap.put(inorder[i], i);
        return buildTree(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        // 找到中序遍历中的左右子树位置和后序遍历中的左右子树位置
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) return null;
        int root = postorder[postorderEnd];
        int inorderRootPosition = inorderMap.get(root);
        TreeNode treeNode = new TreeNode(root);
        int leftLen = inorderRootPosition - inorderStart;
        treeNode.left = buildTree(inorderStart, inorderRootPosition - 1, postorderStart, postorderStart + leftLen - 1);
        treeNode.right = buildTree(inorderRootPosition + 1, inorderEnd, postorderStart + leftLen, postorderEnd - 1);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{};
        int[] postorder = new int[]{};
        TreeNode solution = solution(inorder, postorder);
        TreeNode.print(solution);
    }
}
