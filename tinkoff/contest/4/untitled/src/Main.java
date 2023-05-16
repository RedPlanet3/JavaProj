import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

    public static boolean isMy(HashMap<Integer, Integer> counts)
    {
        return counts.values().size() == 2;
    }
    public static void prefPrint(int[] nums)
    {
        int l = 0;
        int min = 2147483647;
        HashMap<Integer, Integer> counts = new HashMap<>();
        int end = 1;
        if (nums.length < 2)
            System.out.println(1);
        else {
            for (int start = 0; start < nums.length; start++) {
                while (end < nums.length) {
                    if (!counts.containsKey(nums[end]))
                        counts.put(nums[end], 0);
                    counts.put(nums[end], counts.get(nums[end]) + 1);
                    if (isMy(counts))
                        l = l < end - start ? end - start : l;
                    end++;
                }
            }
            System.out.println(l);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (true) {
            in.nextLine();
            prefPrint(toArrayInt(in.nextLine().trim().split(" ")));
//        }

    }
}
