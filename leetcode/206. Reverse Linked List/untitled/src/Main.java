import java.util.ArrayList;
import java.util.List;

//  Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


public class Main {
    static ListNode end;
    public void reqRev(ListNode head)
    {
        if (head.next != null) {
            reqRev(head.next);
            head.next = null;
            end.next = head;
            end = end.next;
        }
        else
            end = head;
    }
    public ListNode reverseList(ListNode head) {
        ListNode answ;
        ListNode tmp;

        ArrayList<ListNode> stack = new ArrayList<>();
        if (head == null)
            return null;
        while (head.next != null) {
            stack.add(head);
             head = head.next;
        }
        answ = head;
        ListNode copy = answ;
        while (stack.size() > 0) {
            tmp = stack.get(stack.size() - 1);
            tmp.next = null;
            answ.next = tmp;
            stack.remove(stack.size() - 1);
            answ = answ.next;
        }
        return copy;

    }
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        ListNode d = new Main().reverseList(list);
        System.out.println();
    }
}