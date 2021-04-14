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
    public ListNode(Integer value,ListNode next) {
        this.value = value;
        this.next = next;
    }

    public void print(String title) {
        System.out.println(title);
        ListNode p = next;
        System.out.print(value);
        if (p == null) {
            System.out.println();
            return;
        }
        while (p.next != null) {
            System.out.print("=>");
            System.out.print(p.value);
            p = p.next;
        }
        System.out.print("=>");
        System.out.print(p.value);
        System.out.println();
    }
}
