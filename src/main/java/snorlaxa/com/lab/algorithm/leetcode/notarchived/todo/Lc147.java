package snorlaxa.com.lab.algorithm.leetcode.notarchived.todo;

import snorlaxa.com.lab.algorithm.base.ListNode;

/**
 * @Author: 余子毅
 * @Date: 2021/10/13 11:21
 * @题意: 对链表进行插入排序
 * 1 2 4 3
 */
public class Lc147 {
    public static void solution(ListNode head) {
        ListNode dummy = new ListNode(0, head), p = head, pre = dummy;

        while (p != null) {
            // 从前往后找合适的插入位置
            ListNode q = dummy;
            int val = p.val;
            while (q.next.val < val && q.next != p) {
                q = q.next;
            }
            // p断开
            ListNode temp = p.next;
            if (q.next != p) {
                pre.next = p.next;
                // p插入到q后面
                p.next = q.next;
                q.next = p;
            } else {
                pre = p;
            }


            p = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        ListNode head = ListNode.fromArray(nums);
        head.print();
        solution(head);
        head.print();

    }
}
