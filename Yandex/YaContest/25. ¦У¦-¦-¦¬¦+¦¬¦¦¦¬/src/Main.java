import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        Arrays.sort(arr);
        int len = 0;
        len += arr[1] - arr[0];
        for(int i = 2; i < n; i++)
        {
            if (i + 1 >= n)
                len += arr[i] - arr[i - 1] ;
            else if (arr[i] - arr[i - 1] < arr[i + 1] - arr[i])
                len += arr[i] - arr[i - 1];
            else {
                len += arr[i + 1] - arr[i];
                i++;
            }
        }
//        if(n > 2)
//            len += arr[arr.length - 1] - arr[arr.length - 2];
        System.out.println(len);
    }
}