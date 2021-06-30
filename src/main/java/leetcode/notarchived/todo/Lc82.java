package leetcode.notarchived.todo;

import base.ListNode;

/**
 * @Author: 余子毅
 * @Date: 2021/6/30 14:29
 * @题意: 删除排序链表中的重复元素2.重复元素节点需要去除
 * 2->2->3->4->4->5
 * 变成
 * 3->5
 * 双指针，一个指针向前探索只有一个元素的数据，遇到此类数据会把它加入到slow指针构成的新链表中
 */
public class Lc82 {
    public static ListNode solution(ListNode head) {
        if (head == null) return null;
        ListNode realHead = new ListNode();
        realHead.next = head;
        ListNode fast = head, slow = realHead;
        while (fast != null) {
            int count = 0;
            while (fast.next != null
                    && fast.value.equals(fast.next.value)) {
                fast = fast.next;
                count++;
            }
            if (count == 0) {
                // 找到单个数据
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return realHead.next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,7,7,8};
        ListNode head = ListNode.fromArray(nums);
        ListNode.print(head);
        ListNode solution = solution(head);
        ListNode.print(solution);
    }
}
