package base;

/**
 * @Author: Yzy
 * @Date: 2021/1/11 11:10
 */
public class ListNode {
    public Integer value;
    public ListNode next;

    public ListNode(Integer value) {
        this.value = value;
        this.next = null;
    }

    public ListNode() {
        this.value = null;
        this.next = null;
    }

    public ListNode(Integer value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public void print() {
        ListNode p = next;
        System.out.print(value);
        if (p == null) {
            System.out.println();
            return;
        }
        while (p.next != null) {
            System.out.print("->");
            System.out.print(p.value);
            p = p.next;
        }
        System.out.print("->");
        System.out.print(p.value);
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
        System.out.print(head.value);
        if (p == null) {
            System.out.println();
            return;
        }
        while (p.next != null) {
            System.out.print("->");
            System.out.print(p.value);
            p = p.next;
        }
        System.out.print("->");
        System.out.print(p.value);
        System.out.println();
    }
}
