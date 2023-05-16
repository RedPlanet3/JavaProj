import java.util.HashMap;

/**
 * Definition for singly-linked list.
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }


public class Solution {
    public int lenList(ListNode head)
    {
        int ch = 0;
        while (head != null) {
            head = head.next;
            ch++;
        }
        return ch;
    }

    public ListNode detectCycle(ListNode head) {
        HashMap<ListNode,ListNode> dict = new HashMap<>();
        dict.put(head, null);
        while (head != null)
        {
            if (head.next != null) {
                if (!dict.containsKey(head.next)) {
                    dict.put(head, head.next);
                    dict.put(head.next, null);
                }
                else
                    return head.next;
            }
            head = head.next;
        }
        return null;
    }
}
