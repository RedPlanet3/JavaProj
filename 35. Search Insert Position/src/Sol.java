import java.util.Scanner;

public class Sol {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int med;
        if (target < nums[start])
            return 0;
        if (target > nums[end])
            return end + 1;
        while(start < end)
        {
            med = (start + end) / 2;
            if (target == nums[med])
                return med;
            if (nums[med] > target)
                end = med;
            else
                start = med + 1;
        }
        return start;
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
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int []arr = toIntArray(in.nextLine().trim().split(" "));
        int targ = in.nextInt();
        int k = new Sol().searchInsert(arr, targ);
            System.out.print(k);
    }
}
