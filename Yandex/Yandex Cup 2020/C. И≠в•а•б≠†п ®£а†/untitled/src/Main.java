import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int pet = 0;
        int vas = 0;
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int n = in.nextInt();
        int num = 0;

        for(int i = 0; i < n; i++)
        {
            num = in.nextInt();
            if ((num % 5 == 0) && (num % 3 == 0))
                continue;
            if (num % 5 == 0)
                vas++;
            if (num % 3 == 0)
                pet++;
            if (pet == k || vas == k)
                break;
        }
        if (pet > vas)
            System.out.printf("Petya");
        else if (pet < vas)
            System.out.printf("Vasya");
        else
            System.out.printf("Draw");
    }
}