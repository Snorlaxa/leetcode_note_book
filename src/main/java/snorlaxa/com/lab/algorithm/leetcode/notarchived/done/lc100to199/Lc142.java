package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc100to199;

import snorlaxa.com.lab.algorithm.base.ListNode;

/**
 * @Author: Yzy
 * @Date: 2021/9/25 15:54
 * @题解: 环形链表2.找出环的入口并返回
 */
public class Lc142 {
    public static ListNode solution(ListNode head) {
        // 识别出环的起始节点
        // 如果环长度是n，快指针一定能在n步之内追上慢指针，因为每次都比慢指针快一步，他俩相差的步数却小于n
        if (head == null) return null;
        ListNode fast = head, slow = head, ring = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                // 发现有环
                break;
            }
        }
        // 无环
        if (fast == null || fast.next == null) return null;

        // 寻找环起始点
        while (slow != ring) {
            slow = slow.next;
            ring = ring.next;
        }

        return ring;
    }
}
