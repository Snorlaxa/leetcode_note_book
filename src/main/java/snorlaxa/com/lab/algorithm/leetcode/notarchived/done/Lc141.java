package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

import snorlaxa.com.lab.algorithm.base.ListNode;

/**
 * @Author: Yzy
 * @Date: 2021/9/25 15:49
 * @题解: 环形链表，判断单链表中是否有环
 */
public class Lc141 {
    public static boolean solution(ListNode head) {
        if (head == null) return false;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
