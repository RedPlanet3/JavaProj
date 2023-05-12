import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
	    int n = in.nextInt();
        int k = in.nextInt();
        int m = in.nextInt();
        int sum_m = 0;
        if (!(k > n || m > k)) {
            while (n / k > 0) {
                sum_m += (n / k) * (k / m);
                n = (n / k) * (k % m) + (n % k);
            }
        }
        System.out.print(sum_m);
    }
}
