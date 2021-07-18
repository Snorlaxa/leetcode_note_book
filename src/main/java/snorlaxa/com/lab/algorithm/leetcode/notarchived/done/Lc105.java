package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

import snorlaxa.com.lab.algorithm.base.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 余子毅
 * @Date: 2021/7/18 10:46
 * @题意: 前序遍历和中序遍历生成二叉树
 */
public class Lc105 {
    int[] preorder;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public static TreeNode solution(int[] preorder, int[] inorder) {
        Lc105 lc105 = new Lc105();
        return lc105.buildTree(preorder, inorder);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) inorderMap.put(inorder[i], i);
        return buildTree(0, inorder.length - 1, 0, preorder.length - 1);
    }

    private TreeNode buildTree(int inorderStart, int inorderEnd, int preorderStart, int preorderEnd) {
        // 找到中序遍历中的左右子树位置和先序遍历中的左右子树位置
        if (inorderStart > inorderEnd || preorderStart > preorderEnd) return null;
        int root = preorder[preorderStart];
        int inorderRootPosition = inorderMap.get(root);
        TreeNode treeNode = new TreeNode(root);
        int leftLen = inorderRootPosition - inorderStart;
        treeNode.left = buildTree(inorderStart, inorderRootPosition - 1, preorderStart + 1, preorderStart + leftLen);
        treeNode.right = buildTree(inorderRootPosition + 1, inorderEnd, preorderStart + leftLen + 1, preorderEnd);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        TreeNode solution = solution(preorder, inorder);
        TreeNode.print(solution);
    }
}
