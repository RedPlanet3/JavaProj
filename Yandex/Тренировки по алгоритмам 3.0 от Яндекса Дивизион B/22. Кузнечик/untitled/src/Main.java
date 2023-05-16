import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        if (n < 2) {
            System.out.println(1);
            return;
        }
//        if (k == 1)
//        {
//            System.out.println(n - 1);
//            return;
//        }
        long []arr = new long[n - 1];
        long sum = 1;
        int ch = 1;
        arr[0] = 1L;
        if (k > 1)
            arr[1] = 2L;
        else
            arr[1] = 1;
        ch++;
        sum = arr[0] + arr[1];
        for(int i = 2; i < n - 1; i++)
        {
            if (ch > k)
                sum -= arr[i - k - 1];
            arr[i] = k > i ? sum + 1 : sum;
            sum += arr[i];
            ch++;
        }
        System.out.println(arr[n-2]);
    }
}