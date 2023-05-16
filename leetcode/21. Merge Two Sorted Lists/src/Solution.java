import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newList = new ListNode(0, null);
        ListNode copyList = newList;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newList.next = new ListNode(list1.val, null);
                list1 = list1.next;
            }
            else {
                newList.next = new ListNode(list2.val, null);
                list2 = list2.next;
            }

            newList = newList.next;
        }
        while (list1 != null) {
            newList.next = new ListNode(list1.val, null);
            list1 = list1.next;
            newList = newList.next;
        }
        while (list2 != null) {
            newList.next = new ListNode(list2.val, null);
            list2 = list2.next;
            newList = newList.next;
        }
        copyList = copyList.next;
        return copyList;
    }

    public static int[] toIntArray(String []str)
    {
        if (str[0].equals(""))
            return null;
        int []arr = new int[str.length];
        for (int i = 0; i < str.length; i++)
            arr[i] = Integer.parseInt(str[i].trim());
        return arr;
    }


    public static ListNode fillList(ListNode list, int []arr)
    {
        if (arr == null)
            return null;
        ListNode tmplist = list;
        for (int num : arr )
        {
            tmplist.next = new ListNode(num, null);
            tmplist = tmplist.next;
        }

        return tmplist;
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(0, null);
        ListNode list2 = new ListNode(0, null);;
        ListNode mergeList;
        Scanner in = new Scanner(System.in);
        if (in.hasNextLine())
            fillList(list1, toIntArray(in.nextLine().trim().split(",")));
        if (in.hasNextLine())
            fillList(list2, toIntArray(in.nextLine().trim().split(",")));
        list1 = list1.next;
        list2 = list2.next;
        mergeList = new Solution().mergeTwoLists(list1, list2);
        while (mergeList != null) {
            System.out.print(mergeList.val + " ");
            mergeList = mergeList.next;
        }
    }
}