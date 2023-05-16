import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int c = in.nextInt();
        int b = in.nextInt();
        if (a + b > c &&
        a + c > b &&
        c + b > a)
            System.out.printf("YES");
        else
            System.out.printf("NO");
    }
}
