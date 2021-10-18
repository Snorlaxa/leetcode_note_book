package snorlaxa.com.lab.algorithm.leetcode.notarchived.todo;

import snorlaxa.com.lab.algorithm.base.ListNode;

/**
 * @Author: 余子毅
 * @Date: 2021/10/13 11:21
 * @题意: 对链表进行插入排序
 * 1 2 4 3
 */
public class Lc147 {
    public static ListNode solution(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE, head), p = head, pre = dummy;

        while (p != null) {
            // 从前往后找合适的插入位置
            ListNode q;
            for (q = dummy; q.next != null && q.next != p; q = q.next) {
                // 寻找插入位置
                if (q.next.val > p.val) {
                    break;
                }
            }
            if (p == q.next) {
                //跳过本次
                pre = p;
                p = p.next;
                continue;
            }

            // 找到了位置
            // 从pre和p.next之间断开
            pre.next = p.next;
            ListNode temp = p.next;
            // 插入q后面
            p.next = q.next;
            q.next = p;

            p = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        /**
         * Integer.MIN_VALUE, 5, 4, 6, 2, 1
         * 找到4应该处于的位置:从前往后遍历直到遇到第一个大于4的数，如果这个数等于4并且与自己的位置相同，说明位置不需要变动
         * 4 与5、3断开
         * 4插入dummy与5之间
         * pre 仍然指向5
         *
         * 如果是6，不需要调整
         * pre指向6
         */
        int[] nums = new int[]{2, Integer.MIN_VALUE};
        ListNode head = ListNode.fromArray(nums);
        head.print();
        ListNode res = solution(head);
        res.print();
    }
}
