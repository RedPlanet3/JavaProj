import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int row = in.nextInt();
        int seat = in.nextInt();
//        (((k - (row * 2) % k) - 2) + 2 - seat - + k) % k
        int vasBack = row * 2 - (2 - seat) + k;
        int vasFront = row * 2 - (2 - seat) - k;
        if (vasFront <= 0 && vasBack > n)
            System.out.println(-1);
        else {
            int tmpFront = vasFront % 2 == 0 ? (vasFront / 2) : (vasFront / 2) + 1;
            int tmpBack = vasBack % 2 == 0? (vasBack / 2) : (vasBack / 2) + 1;
            if (vasFront > 0 && vasBack <= n)
            {
               if  (row - tmpFront < tmpBack - row)
                   System.out.printf("%d %d\n", tmpFront, vasFront % 2 == 0 ? 2 : 1);
               else
                   System.out.printf("%d %d\n", tmpBack, vasBack % 2 == 0 ? 2 : 1);
            }
            else if (vasBack > n)
                System.out.printf("%d %d\n", tmpFront, vasFront % 2 == 0 ? 2 : 1);
            else
                System.out.printf("%d %d\n", tmpBack, vasBack % 2 == 0 ? 2 : 1);
        }
    }
}