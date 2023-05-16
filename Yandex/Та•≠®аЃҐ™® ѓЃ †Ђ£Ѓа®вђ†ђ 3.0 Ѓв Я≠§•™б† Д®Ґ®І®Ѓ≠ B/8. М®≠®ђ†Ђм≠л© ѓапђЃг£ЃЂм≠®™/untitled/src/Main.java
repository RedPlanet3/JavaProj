import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] tmp = new int[2];
        int[] minMax = {2147483647, 2147483647, -2147483648, -2147483648};
        for(int i = 0; i < n; i++)
        {
            String[] str = in.nextLine().trim().split(" ");
            tmp[0] = Integer.parseInt(str[0]);
            tmp[1] = Integer.parseInt(str[1]);
            minMax[0] = minMax[0] > tmp[0] ? tmp[0] :  minMax[0];
            minMax[1] = minMax[1] > tmp[1] ? tmp[1] : minMax[1];
            minMax[2] = minMax[2] < tmp[0] ? tmp[0] :  minMax[2];
            minMax[3] = minMax[3] < tmp[1] ? tmp[1] : minMax[3];
        }
        System.out.printf("%d %d %d %d", minMax[0], minMax[1], minMax[2], minMax[3]);
    }
}