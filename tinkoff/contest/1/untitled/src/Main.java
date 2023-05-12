import java.util.Scanner;

public class Main {
    public static int[] toArrayInt(String s[])
    {
        if (s[0].equals(""))
            return null;
        int []arr = new int[s.length];
        for (int i = 0; i < s.length; i++)
            arr[i] = Integer.parseInt(s[i]);
        return arr;
    }

    public static boolean lookArr(int start, int end, int k, int[] nums)
    {
        for (int i = start + k; i != end + k; i += k)
        {
            if (nums[i] < nums[i - k])
                return false;
        }
        return true;
    }
    public static boolean isSort(int[] nums)
    {
        if (nums == null || nums.length < 2)
            return true;
        if (nums[0] <= nums[nums.length - 1])
            return lookArr(0, nums.length - 1, 1, nums);
        return lookArr( nums.length - 1, 0, -1, nums);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if (isSort(toArrayInt(in.nextLine().trim().split(" "))))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}