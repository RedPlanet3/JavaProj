import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    static int [][][]arr;
    static int kup = 0;
    public static int myMin(int dinnerPrice, int kup, int x1, int y1, int x2, int y2, int i, int j)
    {
        if (dinnerPrice <= kup) {
            arr[i][j][1] = x1;
            arr[i][j][2] = y1;
            return dinnerPrice;
        }
        arr[i][j][1] = x2;
        arr[i][j][2] = y2;
        return kup;
    }
    public static void printArr(int [][][]arr, int n)
    {
        for (int i = 0; i < n + 1; i++) {
            for (int[] num : arr[i]) {
                if (num[0] >= 2147482647)
                    System.out.printf("%8s\t", " INF");
                else
                    System.out.printf("%4d[%d,%d]\t", num[0], num[1], num[2]);
            }
            System.out.printf("\n");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] price = new int[n + 1];
        int minSum = 0;
        for (int i = 1; i < n + 1; i++)
            price[i] = in.nextInt();
        arr = new int[n + 1][n + 2][3];
        for (int i = 1; i < n + 1; i++)
        {
            if (price[i] > 100)
                kup++;
            for (int j = 1; j < n + 1; j++)
            {
                if (i == 1)
                    arr[0][j + 1][0] = 2147482647;
                if (price[i] > 100) {
                    arr[i][j][0] = myMin(arr[i - 1][j - 1][0] + price[i],
                            arr[i - 1][j + 1][0], i - 1, j - 1, i - 1, j + 1, i, j);
                }
                else
                    arr[i][j][0] = myMin(arr[i - 1][j][0] + price[i],
                            arr[i - 1][j + 1][0],i - 1, j, i - 1,j + 1,  i, j);
            }
            arr[i][n + 1][0] = 2147482647;
            arr[i][0][0] = arr[i][1][0];
        }
        int i = n,j = 1;
        minSum = arr[i][j][0];
        int maxKup = 0;
        int maxI = i;
        int maxJ = j;
        j++;
        while (j < n + 1 && arr[i][j][0] != 2147482647)
        {
            if (arr[i][j][0] <= minSum) {
                minSum = arr[i][j][0];
                maxI = i;
                maxJ = j;
            }
            j++;
        }
        maxKup = maxJ - 1;
        System.out.printf("%d\n", minSum);
        LinkedList<Integer> daysKup = new LinkedList<>();
        while (maxI > 0) {
            int tmpI = maxI;
            int tmpj = maxJ;
            if (arr[maxI][maxJ][2] > maxJ)
                daysKup.addFirst(maxI);
            maxI = arr[tmpI][tmpj][1];
            maxJ = arr[tmpI][tmpj][2];
        }
        if (daysKup.size() == 0)
            maxKup = kup;
        System.out.printf("%d ", maxKup);

        System.out.println(daysKup.size());
        for (int num: daysKup)
            System.out.println(num);
        System.out.println();
//        printArr(arr, n);
    }
}