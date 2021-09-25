package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

import snorlaxa.com.lab.algorithm.base.ListNode;

/**
 * @Author: Yzy
 * @Date: 2021/9/25 15:44
 * @题意: 重排链表 状如 1-2-3-4-5 的单链表，重排成：1-5-2-4-3
 */
public class Lc143 {
    public static void solution(ListNode head) {
        // 先找出需要反转的链表，断开并反转后面的链表，然后插入
        // 找出长度
        if (head == null) return;
        int n = 0;
        ListNode p = head, pre = null;
        while (p != null) {
            n++;
            p = p.next;
        }
        // 第一段节点数
        int m = (n - 1) / 2;
        p = head;
        // 1 2 3 4 5 6 7 8
        // 1 2 3 4
        while (p != null) {
            if (m <= 0) {
                // 反转链表
                ListNode temp = p.next;
                p.next = pre;
                pre = p;
                p = temp;
            } else {
                m--;
                p = p.next;
            }
        }

        // 此时pre指向第二段的起始

        // 合并两个链表
        p = head;
        ListNode q = pre;
        while (p != null && q != null) {
            ListNode temp1 = p.next;
            ListNode temp2 = q.next;
            p.next = q;
            q.next = temp1;
            p = temp1;
            q = temp2;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        ListNode head = ListNode.fromArray(nums);
        solution(head);
        ListNode.print(head);
    }
}
