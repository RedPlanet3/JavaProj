import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int myMin(int a, int b, int c)
    {
        if (a < b && a < c)
            return a;
        if (b < a && b < c)
            return b;
        return c;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []dp = new int[n + 3];
        ArrayList<int[]> arr = new ArrayList<>();
        arr.add(new int[]{2147483647, 2147483647, 2147483647});
        arr.add(new int[]{2147483647, 2147483647, 2147483647});
        arr.add(new int[]{2147483647, 2147483647, 2147483647});
        for (int i = 0; i < n; i++)
            arr.add(new int[]{in.nextInt(), in.nextInt(), in.nextInt()});
        for (int i = 3; i < n + 3; i++)
        {
            dp[i] = myMin(dp[i - 1] + arr.get(i)[0],
                    dp[i - 2] + arr.get(i - 1)[1],
                    dp[i - 3] + arr.get(i - 2)[2]);
        }
        System.out.println(dp[dp.length - 1]);
    }
}