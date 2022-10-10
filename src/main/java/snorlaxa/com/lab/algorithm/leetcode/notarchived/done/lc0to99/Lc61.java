package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc0to99;

import snorlaxa.com.lab.algorithm.base.ListNode;

/**
 * @Author: Yzy
 * @Date: 2021/6/14 17:56
 * @题意: 旋转链表。给你一个链表的头节点 head，旋转链表，将链表每个节点向右移动 k 个位置。
 * 如：1 2 3 4 5 => 4 5 1 2 3
 */
public class Lc61 {
    public static ListNode solution(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode p1 = head, p2 = head;
        int count = 0;
        while (p1 != null) {
            count++;
            p1 = p1.next;
        }
        k = k % count;

        p1 = head;
        // 快指针移动k步
        while (k > 0) {
            p1 = p1.next;
            k--;
        }

        while (p1.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        // 到达末尾
        p1.next = head;
        head = p2.next;
        p2.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        ListNode head = new ListNode(nums[0]);
        ListNode p = head;
        for (int i = 1; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        ListNode solution = solution(head, 2);
        ListNode.print(solution);
    }
}
