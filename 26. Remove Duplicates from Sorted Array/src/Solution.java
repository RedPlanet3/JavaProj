import java.util.Scanner;

class Solution {
    public int removeDuplicates(int[] nums) {
        int first = 0;
        for(int i = 1; i < nums.length; i++)
        {
            if (nums[first] != nums[i]) {
                nums[first + 1] = nums[i];
                first++;
            }
        }
        return first + 1;
    }

    //0 0 1 1 1 2 2 3 3 4
    //0 0 0
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
        int k = new Solution().removeDuplicates(arr);
        for(int i = 0; i < k; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}