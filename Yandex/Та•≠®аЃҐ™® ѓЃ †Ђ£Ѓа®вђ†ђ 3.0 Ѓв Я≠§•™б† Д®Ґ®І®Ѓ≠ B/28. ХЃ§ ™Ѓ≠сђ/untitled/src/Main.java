import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int [][]arr = new int[n + 2][m + 2];
        arr[0][0] = 1;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (arr[i][j] != 0)
                {
                    arr[i + 1][j + 2] += arr[i][j];
                    arr[i + 2][j + 1] += arr[i][j];
                }
            }
        }
        System.out.println(arr[n - 1][m -1]);
    }
}