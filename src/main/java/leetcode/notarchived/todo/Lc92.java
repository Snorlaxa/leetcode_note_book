package leetcode.notarchived.todo;

import base.ListNode;

/**
 * @Author: 余子毅
 * @Date: 2021/7/1 10:23
 * @题意: 反转链表2. 给定left<=right，翻转从第left个到第right个的链表
 */
public class Lc92 {
    public static ListNode solution(ListNode head, int left, int right) {
        if (head == null) return null;
        /**
         * 1->2->3->4->5
         */
        // 需要一个头节点和两个指针
        ListNode prehead = new ListNode(0, head);
        ListNode slow = prehead, fast = prehead;

        // 翻转起始位置的前一节点，指向翻转的部分
        ListNode prestart = fast;
        // 找到起始位置
        // 跳出时指向自身
        while (slow != null && left > 0) {
            prestart = slow;
            slow = slow.next;
            left--;
            right--;
        }

        // 起始节点，需要指向翻转部分后面的节点
        ListNode leftnode = slow;

        if (slow != null)
            fast = slow.next;
        else
            return head;

        //翻转结束位置的后一节点，被翻转部分指向
        ListNode behindend = fast;

        //翻转
        while (fast != null && right > 0) {
            behindend = fast.next;
            fast.next = slow;
            slow = fast;
            fast = behindend;
            right--;
        }

        prestart.next = slow;
        leftnode.next = behindend;
        return prehead.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        ListNode head = ListNode.fromArray(nums);
        ListNode solution = solution(head, 4, 5);
        ListNode.print(solution);
    }
}
