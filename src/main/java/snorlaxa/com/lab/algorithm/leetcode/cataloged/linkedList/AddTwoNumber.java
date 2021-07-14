package snorlaxa.com.lab.algorithm.leetcode.cataloged.linkedList;

import snorlaxa.com.lab.algorithm.base.ListNode;

/**
 * @Author: Yzy
 * @Date: 2021/1/11 11:10
 * 思路比较常规，主要是两个不同长度链表的同步遍历
 * 在一个while循环里处理比较方便
 * 用一个虚拟节点作为头部，在遍历的时候就可以用p.next去赋值，而不需要考虑起始的赋值
 */
public class AddTwoNumber {
    public ListNode addTowNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(null);
        head.next = new ListNode(null);
        ListNode p = head;
        int add = 0;
        while (l1 != null || l2 != null) {
            int x, y;
            if (l1 == null) {
                x = 0;
            } else {
                x = l1.val;
            }
            if (l2 == null) {
                y = 0;
            } else {
                y = l2.val;
            }
            int value = x + y + add;
            add = value / 10;
            p.next = new ListNode(value % 10);
            p = p.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (add > 0) {
            p.next = new ListNode(add % 10);
        }
        return head.next;
    }

    /**
     * 双链表单个while循环处理模板
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode pattern(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(null);
        head.next = new ListNode(null);
        ListNode p = head;
        while (l1 != null || l2 != null) {
            // 各链表值
            int x, y;
            if (l1 == null) {
                // 链表1终结时，设置无效值
                x = 0;
            } else {
                x = l1.val;
            }
            if (l2 == null) {
                // 链表2终结时，设置无效值
                y = 0;
            } else {
                y = l2.val;
            }
            /**
             * TODO
             *  处理x、y值
             *  得到下一节点的值
             */

            // 创建并指向next
            p.next = new ListNode(null);
            p = p.next;

            // 链表向后遍历
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        // 所有节点遍历完，进行后续处理
        p.next = new ListNode(null);
        return head.next;
    }

    public static ListNode createListNodes(int num, int start, int step) {
        ListNode listNode = new ListNode(start);
        ListNode head = listNode;
        for (int i = 1; i < num; i++) {
            ListNode next = new ListNode(i + step);
            listNode.next = next;
            listNode = next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = createListNodes(1, 1, 1);
        ListNode l2 = createListNodes(2, 5, 1);
        ListNode.print(l1);
        ListNode.print(l2);
        ListNode listNode = newInstance().addTowNumbers(l1, l2);
        ListNode.print(listNode);
    }

    public static AddTwoNumber newInstance() {
        return new AddTwoNumber();
    }
}
