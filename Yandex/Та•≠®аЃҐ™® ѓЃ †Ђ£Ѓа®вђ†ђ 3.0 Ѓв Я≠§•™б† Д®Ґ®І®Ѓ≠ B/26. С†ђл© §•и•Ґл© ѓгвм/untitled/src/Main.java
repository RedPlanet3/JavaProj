import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int [][]arr = new int[n + 1][m + 1];

        for(int i = 0; i < n + 1; i++)
        {
            for (int j = 0; j < m + 1; j++) {
                if (i == n)
                    arr[i][j] = 2147483647;
                else if (j == m)
                    arr[i][j] = 2147483647;
                else
                    arr[i][j] = in.nextInt();
            }
        }
//        System.out.println();
        for(int i = n - 1; i > -1; i--)
        {
            for (int j = m - 1; j > -1; j--) {
                if (i == n - 1 && j == m - 1)
                    continue;
                arr[i][j] = Math.min(arr[i +1][j], arr[i][j + 1]) + arr[i][j];
            }
        }
        System.out.println(arr[0][0]);
    }
}