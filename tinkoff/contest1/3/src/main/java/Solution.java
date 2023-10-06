import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int time = in.nextInt();
        int[] flors = new int[n];
        for(int i = 0; i < n; i++)
            flors[i] = in.nextInt();
        int first = in.nextInt();
        if (flors[n-1] - flors[0] <= time ||
        flors[first - 1] - flors[0] <= time ||
        flors[n - 1] - flors[first - 1] <= time)
            System.out.println(flors[n-1] - flors[0]);
        else
            System.out.println((flors[n-1] - flors[0]) + (Math.min((flors[first - 1] - flors[0]), (flors[n - 1] - flors[first - 1]))));
    }
}
