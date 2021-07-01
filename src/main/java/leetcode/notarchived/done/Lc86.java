package leetcode.notarchived.done;

import base.ListNode;

/**
 * @Author: 余子毅
 * @Date: 2021/6/30 15:55
 * @题意: 分隔链表，给一个x，使得小于x的都在链表左边，大于等于x的都在右边，并且两个区域内的节点保持原本的相对位置
 */
public class Lc86 {
    public static ListNode solution(ListNode head, int x) {
        /**
         * 3->2->1->4->5->3->2->3
         * 2->1->2->3->4->5->3->3
         * 两个指针各自标注，找到小于x的连接到一个指针，大于等于x的连接到另一个指针。
         * 需要一个头节点
         */
        if (head == null || head.next == null) return head;

        ListNode left = new ListNode(), right = new ListNode(), p = head;
        ListNode lhead = left, rhead = right;
        while (p != null) {
            if (p.val < x) {
                left.next = p;
                left = left.next;
            } else {
                right.next = p;
                right = right.next;
            }
            p = p.next;
        }
        if (lhead.next == null) {
            return rhead.next;
        } else {
            left.next = rhead.next;
            right.next = null;
            return lhead.next;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 1};
        ListNode head = ListNode.fromArray(nums);
        ListNode solution = solution(head, 2);
        ListNode.print(solution);
    }
}
