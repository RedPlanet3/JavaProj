import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []arr = new int[n + 1];
        if (n > 0)
            arr[1] = 2;
        if (n > 1)
            arr[2] = 4;
        if (n > 2)
            arr[3] = 7;
        for (int i = 4; i < n + 1; i++)
            arr[i] = (arr[i-1] + arr[i-2] + arr[i-3]);
        System.out.println(arr[n]);
    }
}
