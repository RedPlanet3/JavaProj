
//  Definition for singly-linked list.
   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class Main {

    public int findLast(ListNode head, int k) {
        ListNode tmp = head;
        int count = 0;
        while (tmp != null)
        {
            count++;
            tmp = tmp.next;
        }
        return count;
    }

    public ListNode swapNodes(ListNode head, int k) {
        int size =  findLast(head, k);
        int i = 1;
        ListNode firstS = null;
        ListNode secondS = null;
        ListNode tmp = head;
        while (tmp != null)
        {
            if (i == k)
                firstS = tmp;
            if (i == size - k + 1)
                secondS = tmp;
            tmp = tmp.next;
            i++;
        }
        int g = firstS.val;
        firstS.val = secondS.val;
        secondS.val = g;
        return head;
    }

    public static void main(String[] args) {

    }
}