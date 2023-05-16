import java.util.Scanner;

class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        int first = nums[0] == val? -1: 0;
        for(int i = 0; i < nums.length; i++)
        {
            if (nums[i] != val && i != first) {
                first++;
                nums[first] = nums[i];
            }

        }
        return first + 1;
    }

    //0 0 3 1 1 2 2 3 3 4 -->0 0 1 1 2 2 4
    //3

    public static int[] toIntArray(String []str)
    {
        if (str[0].equals(""))
            return null;
        int []arr = new int[str.length];
        for (int i = 0; i < str.length; i++)
            arr[i] = Integer.parseInt(str[i].trim());
        return arr;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int []arr = toIntArray(in.nextLine().trim().split(" "));
        int k = new Solution().removeElement(arr, 3);
        for(int i = 0; i < k; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}