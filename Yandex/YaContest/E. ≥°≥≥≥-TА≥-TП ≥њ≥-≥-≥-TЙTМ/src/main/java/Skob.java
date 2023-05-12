import java.util.Scanner;

public class Skob {

    public static void skob(StringBuilder str, int n, int cur_n, boolean open)
    {
        if (str.length() == n * 2)
            System.out.println(str);
        else
        {
            if (cur_n < n)
            {
                skob(str.append("("), n, cur_n + 1, true);
                str.deleteCharAt(str.length() - 1);
                if (cur_n * 2 == str.length())
                    open = false;
            }

            if (cur_n > 0 && open) {
                skob(str.append(")"), n, cur_n, open);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder str = new StringBuilder();
        skob(str, in.nextInt(), 0, false);
    }
}
