import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] nI = new int[n + 1];
        for (int i = 1;i < n + 1; i++)
            nI[i] = in.nextInt();
        int m = in.nextInt();
        int [] mI = new int[m + 1];
        for (int i = 1;i < m + 1; i++)
            mI[i] = in.nextInt();
        int [][]arr = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++)
        {
            for (int j = 1; j < m + 1; j++)
            {
                if (nI[i] != mI[j])
                    arr[i][j] = Math.max(arr[i -1][j], arr[i][j - 1]);
                else
                    arr[i][j] = 1 + arr[i - 1][j - 1];
            }
        }
        LinkedList<Integer> list = new LinkedList<>();

        int i = n;
        int j = m;
        while (i > 0 && j > 0)
        {
            if (nI[i] != mI[j]) {
                if (arr[i - 1][j] >= arr[i][j - 1])
                    i--;
                else
                    j--;
            }
            else {
                list.addFirst(nI[i]);
                i--;
                j--;
            }
        }
        for (int num: list)
            System.out.print(num + " ");
    }
}