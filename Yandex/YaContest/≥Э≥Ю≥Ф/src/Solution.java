import java.util.Scanner;

public class Solution {

    public static int nod(int a, int b)
    {
        if (a < 1 || b < 1) {
            System.out.println("Numbers must be more then 0");
            return -1;
        }
        int max = Math.max(a,b);
        int min = Math.min(a,b);

        if ((max % min) == 0)
            return min;
        else
            return nod(min, max % min);
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println(nod(in.nextInt(), in.nextInt()));
    }
}
