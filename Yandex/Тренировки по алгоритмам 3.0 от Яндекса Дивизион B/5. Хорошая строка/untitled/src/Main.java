import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static long sMin(int[] arr, int min)
    {
        long sum = 0;
        int ch = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if ((arr[i] - min) >= 0) {
                ch++;
                arr[i] = arr[i] - min;
            }
            else
            {
                if (ch > 1)
                    sum += (ch - 1L) * min;
                ch = 0;
            }
        }
        if (ch > 1)
            sum += (ch - 1L) * min;
        return sum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[in.nextInt()];
        int min = 2147483647;
        for(int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
            min = arr[i] < min ? arr[i] : min;
        }
        int j = 0;
        int ch = 0;
        long sum = 0;
        int start = 0;
        int end = arr.length;
        int tmp = arr.length;
        for(int i = 1; i < arr.length; i++)
            sum += Math.min(arr[i], arr[i - 1]);
        System.out.println("3: " + sum);
        sum = 0;
        sum += sMin(arr, min);
        while (true)
        {
            ch = 0;
            while ((j < arr.length && arr[j] == 0)) {
                j++;
                start++;
            }

            while (j < arr.length && arr[j] != 0) {
                arr[j++]--;
                ch++;
            }
            if (ch == 1)
                arr[j - 1] = 0;
            while ((j < arr.length && arr[j] == 0)) {
                j++;
                tmp--;
            }
            if (j == end)
                end = tmp;
            sum = ch > 0 ? sum + ch - 1 : sum;
            j = j < end ? j : start;
            if (ch == 0)
                break;
        }
        System.out.println("1: " + sum);
    }
}