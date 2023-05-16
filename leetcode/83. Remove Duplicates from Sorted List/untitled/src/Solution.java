<<<<<<< HEAD
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode tmp = head;
        ListNode tmpT = head;
        while (tmp.next != null)
        {
            if (tmp.next.val == tmp.val) {
                tmpT = tmp;
                while (tmpT.next != null && tmpT.next.val == tmpT.val)
                    tmpT = tmpT.next;
                tmp.next = tmpT.next;
            }
            if (tmp.next != null) tmp = tmp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        System.out.println(new Solution().deleteDuplicates(head));
    }
}
=======
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode tmp = head;
        ListNode tmpT = head;
        while (tmp.next != null)
        {
            if (tmp.next.val == tmp.val) {
                tmpT = tmp;
                while (tmpT.next != null && tmpT.next.val == tmpT.val)
                    tmpT = tmpT.next;
                tmp.next = tmpT.next;
            }
            if (tmp.next != null) tmp = tmp.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        System.out.println(new Solution().deleteDuplicates(head));
    }
}
>>>>>>> 46aaba03c9ce4eaf46f95820b00c760cbcdc982c
