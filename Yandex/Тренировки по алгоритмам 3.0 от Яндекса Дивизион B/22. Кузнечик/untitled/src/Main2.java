import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long []arr = new long[n];
        long sum = 1;
        int ch = 1;
        arr[0] = 1;
        if(n > 1)
            arr[1] = 1;
//        else
//        {
//            System.out.println(1);
//            return;
//        }
        if (k > 1) {
            arr[2] = 2;
            ch++;
            sum = arr[1] + arr[2];
        }
        for(int i = 3; i < n; i++)
        {
            if (ch > k)
                sum -= arr[i - k - 1];
            arr[i] = k > i ? sum + 1 : sum;
            sum += arr[i];
            ch++;
        }
        System.out.println(arr[n - 1]);
    }
}