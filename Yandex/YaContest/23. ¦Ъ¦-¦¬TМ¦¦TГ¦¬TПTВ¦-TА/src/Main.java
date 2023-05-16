import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> answ = new ArrayList<>();
    static int []dp;
    static int divTwo;
    static int divTree;

    public static int myMin(int a, int b, int c, int i)
    {
        if (a <= b && a <= c) {
            answ.add(divTwo);
            return a;
        }
        if (b <= a && b <= c) {
            answ.add(divTree);
            return b;
        }
        answ.add(i - 1);
        return c;
    }

    public static int canDiv(int num, int div)
    {
        if (num % div == 0) {
            if (div == 2)
                divTwo = num / div;
            else
                divTree = num / div;
            return dp[num / div];
        }
        return 2147483646;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        dp = new int[n + 1];
        answ.add(0);
        answ.add(1);
        for(int i = 2; i < n + 1; i++)
            dp[i] = myMin(canDiv(i, 2) + 1, canDiv(i, 3) + 1, dp[i - 1] + 1, i);
        System.out.println(dp[n]);
        StringBuilder str = new StringBuilder();
        str.insert(0,n);
        int tmp = n;
        while (tmp > 1)
        {
            str.insert(0, " ");
            tmp = answ.get(tmp);
            str.insert(0, tmp);
        }
        System.out.println(str);
    }
}
