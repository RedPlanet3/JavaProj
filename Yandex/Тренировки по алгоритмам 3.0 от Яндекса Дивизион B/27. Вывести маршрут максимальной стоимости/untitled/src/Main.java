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
                    arr[i][j] = -1;
                else if (j == m)
                    arr[i][j] = -1;
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
                arr[i][j] = Math.max(arr[i +1][j], arr[i][j + 1]) + arr[i][j];
            }
        }
        System.out.println(arr[0][0]);
        int row = 0;
        int line = 0;
        while ((row < n - 1) || (line < m - 1))
        {
            if (arr[row + 1][line] >= arr[row][line + 1])
            {
                row = row + 1;
                System.out.print("D ");
            }
            else
            {
                line = line + 1;
                System.out.print("R ");
            }
        }
    }
}