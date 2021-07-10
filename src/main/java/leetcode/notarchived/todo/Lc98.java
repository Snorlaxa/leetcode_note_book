package leetcode.notarchived.todo;

import base.TreeNode;

/**
 * @Author: 余子毅
 * @Date: 2021/7/6 11:48
 * @题意: 验证二叉搜索树。 判断一棵二叉搜索树是否有效。
 */
public class Lc98 {
    public static boolean solution(TreeNode root) {
        /**
         * 左子树的根小于root，右子树的根大于root，以此类推
         * 会出现问题：如[4,1,5,null,null,2],2满足当前节点，但小于上一个根节点
         * 找左边的最小值，和右边的最大值
         */
        return dfs2(root, Integer.MIN_VALUE);
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
    private static boolean dfs2(TreeNode root, int pre) {
        if (root == null) return true;
        if (!dfs2(root.left, pre)) return false;
        if (pre <= root.val) return false;
        pre = root.val;
        return dfs2(root.right, pre);
    }


    public static void main(String[] args) {
        Integer[] nums = new Integer[]{4, 1, 5, null, null, 2};
        TreeNode treeNode = TreeNode.fromArray(nums);
        boolean solution = solution(treeNode);
        System.out.println(solution);
    }
}
