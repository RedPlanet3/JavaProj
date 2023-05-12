import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int sumPref(int[] pref, int x, int ySt, int yEnd, int m)
    {
        return pref[(x - 1) * m + Math.max(ySt , yEnd)] - pref[(x - 1) * m + Math.min(ySt ,yEnd) - 1];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] size = {in.nextInt(), in.nextInt()};
        int k = in.nextInt();
        int[] pref = new int[size[0] * size[1] + 1];
        int[] xyxy;
        int sum;
        for (int i = 1; i < size[0] * size[1] + 1; i++)
            pref[i] = pref[i - 1] + in.nextInt();
        for(int i = 0; i < k; i++) {
            xyxy = new int[]{in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()};
            int j = Math.min(xyxy[0], xyxy[2]);
            int end = Math.max(xyxy[0], xyxy[2]);
            sum = 0;
            while (j <= end) {
                sum += sumPref(pref, j, xyxy[1], xyxy[3], size[1]);
                j++;
            }
            System.out.println(sum);
        }
    }
}