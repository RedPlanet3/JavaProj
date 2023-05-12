///Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Main {
    public int lenList(ListNode head)
    {
        int ch = 0;
        while (head != null) {
            head = head.next;
            ch++;
        }
        return ch;
    }
    public ListNode middleNode(ListNode head) {
        int len = lenList(head);
        for (int i = 0; i < len/2; i++)
            head = head.next;
        return head;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}