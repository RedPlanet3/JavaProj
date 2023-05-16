import java.util.Scanner;

public class Solution {

    public static void interv(int[] arr, int time, int n)
    {
        arr[0] = n + ((n -1) * time);
        arr[1] = arr[0] + 2 * time;
    }

    public static void anz(int[] first, int[] second)
    {
        if ((first[1] - second[0] < 0) || (second[1] - first[0] < 0))
            System.out.println(-1);
        else
        {
            System.out.println(Math.max(first[0], second[0]) + " " +
                                Math.min(first[1], second[1]));
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] first = new int[2];
        int[] second = new int[2];

        interv(first, a, n);
        interv(second, b, m);
        anz(first, second);
    }
}
