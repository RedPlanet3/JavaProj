import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        Arrays.sort(arr);
        int []dp = new int[n];
        dp[1] = arr[1] - arr[0];
        if (n > 2)
            dp[2] = arr[2] - arr[0];
        for(int i = 3; i < n; i++)
            dp[i] = Math.min(dp[i-1],dp[i-2]) + arr[i] - arr[i-1];
        System.out.println(dp[n - 1]);
    }
}