package snorlaxa.com.lab.algorithm.leetcode.notarchived.todo;

import snorlaxa.com.lab.algorithm.base.ListNode;
import snorlaxa.com.lab.algorithm.base.TreeNode;

/**
 * @Author: 余子毅
 * @Date: 2021/7/18 12:05
 * @题意: 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 */
public class Lc109 {
    ListNode current;

    public static TreeNode solution(ListNode head) {
        /**
         * 1->2->3->4->5
         * 取中点作为根，两边作为左右子树。递归构建
         * 12->1 2
         * 45->4 5
         * 因为树升序，所以可以将其视作中序遍历的顺序
         */
        return new Lc109().buildTree(head);
    }

    private TreeNode buildTree(ListNode head) {
        this.current = head;
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return buildTree(0, length - 1);
    }

    private TreeNode buildTree(int start, int end) {
        if (start > end) return null;
        int mid = start + end + 1 >> 1;
        TreeNode left = buildTree(start, mid - 1);
        TreeNode root = new TreeNode(this.current.val);
        root.left = left;
        current = current.next;
        root.right = buildTree(mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        ListNode listNode = ListNode.fromArray(nums);
        TreeNode solution = solution(listNode);
        TreeNode.print(solution);
    }
}
