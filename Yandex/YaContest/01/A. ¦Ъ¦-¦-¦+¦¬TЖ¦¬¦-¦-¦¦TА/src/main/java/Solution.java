import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cur = in.nextInt();
        int pref = in.nextInt();
        String act = in.next();
        int answ = 0;
        switch (act)
        {
            case ("freeze"):
                answ = cur > pref ? pref : cur;
                break;
            case ("heat"):
                answ = cur > pref ? cur : pref;
                break;
            case ("auto"):
                answ = pref;
                break;
            case ("fan"):
                answ = cur;
                break;
        }
        System.out.printf(String.valueOf(answ));
    }
}
