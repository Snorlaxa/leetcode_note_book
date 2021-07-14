package snorlaxa.com.lab.algorithm.base;

/**
 * @Author: Yzy
 * @Date: 2021/1/11 11:10
 */
public class ListNode {
    public Integer val;
    public ListNode next;

    public ListNode(Integer val) {
        this.val = val;
        this.next = null;
    }

    public ListNode() {
        this.val = null;
        this.next = null;
    }

    public ListNode(Integer val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        ListNode p = next;
        System.out.print(val);
        if (p == null) {
            System.out.println();
            return;
        }
        while (p.next != null) {
            System.out.print("->");
            System.out.print(p.val);
            p = p.next;
        }
        System.out.print("->");
        System.out.print(p.val);
        System.out.println();
    }

    public static ListNode fromArray(int[] nums) {
        ListNode head = new ListNode();
        ListNode p = head;
        for (int i : nums) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return head.next;
    }

    public static void print(ListNode head) {
        if (head == null) return;
        ListNode p = head.next;
        System.out.print(head.val);
        if (p == null) {
            System.out.println();
            return;
        }
        while (p.next != null) {
            System.out.print("->");
            System.out.print(p.val);
            p = p.next;
        }
        System.out.print("->");
        System.out.print(p.val);
        System.out.println();
    }
}
