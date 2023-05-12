import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int first = in.nextInt();
        int second;
        long sum = 0;
        for(int i = 1; i < n; i++) {
            second = in.nextInt();
            sum += Math.min(first, second);
            first = second;
        }
        System.out.println(sum);
    }
}