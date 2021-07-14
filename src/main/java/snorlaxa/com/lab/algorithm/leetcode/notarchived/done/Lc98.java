package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

import snorlaxa.com.lab.algorithm.base.TreeNode;

/**
 * @Author: 余子毅
 * @Date: 2021/7/6 11:48
 * @题意: 验证二叉搜索树。 判断一棵二叉搜索树是否有效。
 */
public class Lc98 {
    static Integer pre = Integer.MIN_VALUE;
    public static boolean solution(TreeNode root) {
        return dfs2(root);
    }

    private static boolean dfs(TreeNode root) {
        if (root == null) return true;
        boolean res = (root.left == null || (root.left.val < root.val))
                && (root.right == null || (root.right.val > root.val));
        return res && dfs(root.left) && dfs(root.right);
    }

    /**
     * 中序遍历严格升序
     *
     * @param root 根节点
     * @return 是否验证通过
     * 中序遍历，大于前驱指针
     */
    private static boolean dfs2(TreeNode root) {
        if (root == null) return true;
        if (!dfs2(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        return dfs2(root.right);
    }


    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1,1};
        TreeNode treeNode = TreeNode.fromArray(nums);
        boolean solution = solution(treeNode);
        System.out.println(solution);
    }
}
