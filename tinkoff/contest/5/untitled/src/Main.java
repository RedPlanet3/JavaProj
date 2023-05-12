
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
    public static void normPrint(int[] nums)
    {
        int ch = 0;
        int end = 1;
        int sum = nums[0];
        for (int start = 0; start < nums.length; start++)
        {
            while (end < nums.length && sum != 0)
                sum += nums[end++];
            if (sum == 0)
                ch += nums.length - end + 1;
            if (end == nums.length)
                break;
            sum -= nums[start];
        }
        System.out.println(ch);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (true) {
            in.nextLine();
            normPrint(toArrayInt(in.nextLine().trim().split(" ")));
//        }
    }
}