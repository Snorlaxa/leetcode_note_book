package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc100to199;

import snorlaxa.com.lab.algorithm.base.TreeNode;

/**
 * @Author: 余子毅
 * @Date: 2021/6/23 20:47
 * @题意: 二叉树的最小深度
 */
public class Lc111 {
    public int solution(TreeNode root) {
        if (root == null) return 0;
        int l = solution(root.left);
        int r = solution(root.right);
        // 若两个都是0，说明到叶子节点，若有一方不是0，说明还没到叶子节点，继续返回
        // 如果两方都有，返回小的那个
        int res = (l == 0 || r == 0) ? Math.max(l, r) : Math.min(l, r);
        // 加1表示访问到当前的节点
        return res + 1;
    }

    public static void main(String[] args) {

    }
}
