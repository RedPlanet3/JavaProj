import java.util.Scanner;

public class Solution {
    public static void my_sort(int[] kub)
    {
        boolean sort = false;
        int tmp;
        while(!sort)
        {
            sort = true;
            for (int i = 0; i < kub.length - 1; i++) {
                if (kub[i] < kub[i + 1]) {
                    tmp = kub[i];
                    kub[i] = kub[i + 1];
                    kub[i + 1] = tmp;
                    sort = false;
                }
            }
        }
    }

    public static boolean choise(int[] kub, int d, int e, int ind)
    {
        if (Math.max(d,e) >= kub[ind]) {
            if ((Math.min(d, e) >= kub[ind - 1]) ||
                    ((ind - 2 >= 0) && Math.min(d, e) >= kub[ind - 2]))
                System.out.println("YES");
            else
                System.out.println("NO");
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int[] kub = new int[3];
        kub[0] = in.nextInt();
        kub[1] = in.nextInt();
        kub[2] = in.nextInt();
        int d = in.nextInt();
        int e = in.nextInt();
        my_sort(kub);
        if (!choise(kub, d, e, 2)) {
            if (!choise(kub, d, e, 1))
                System.out.println("NO");
        }
    }
}
