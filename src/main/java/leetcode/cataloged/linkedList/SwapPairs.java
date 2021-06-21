package leetcode.cataloged.linkedList;

import base.ListNode;

/**
 * @Author: snorlaxa
 * @Date: 2021/3/2 23:28
 * @题意： 两两交换链表中的节点，即两个两个地交换链表中的节点
 * @题解： 加入一个指向head的pre节点，会发现每次交换一共会影响三个节点：交换节点和指向他们的前驱结点。可以视为一种递归行为，也可采用迭代
 */
public class SwapPairs {
    public ListNode solution(ListNode head) {
        ListNode tmpHead = new ListNode(0, head);
        ListNode pre = tmpHead;
        while (pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            ListNode node2 = pre.next.next;
            //swap
            node1.next = node2.next;
            node2.next = node1;
            pre.next = node2;
            pre = node1;
        }
        return tmpHead.next;
    }

}
