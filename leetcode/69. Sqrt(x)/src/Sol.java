public class Sol {
    public int mySqrt(int x) {
        for (int i = 1; i < 46341; i++)
        {
            if (i * i == x)
                return i;
            else if (i * i > x)
                return i - 1;
        }
        return 46340;
    }

    public static void main(String[] args) {
        System.out.println("46340: " + new Sol().mySqrt(2147483647));
        System.out.println("2: " + new Sol().mySqrt(4));
        System.out.println("3: " + new Sol().mySqrt(12));
        System.out.println("81: " + new Sol().mySqrt(6589));
        System.out.println("35: " + new Sol().mySqrt(1245));
        System.out.println("6: " + new Sol().mySqrt(47));
        System.out.println("1: " + new Sol().mySqrt(1));
        System.out.println("23: " + new Sol().mySqrt(566));
        System.out.println("9: " + new Sol().mySqrt(99));
        System.out.println("3: " + new Sol().mySqrt(9));
        System.out.println("9: " + new Sol().mySqrt(81));
        System.out.println("5: " + new Sol().mySqrt(25));
        System.out.println("15: " + new Sol().mySqrt(255));
        System.out.println("15: " + new Sol().mySqrt(225));
        System.out.println("11: " + new Sol().mySqrt(121));
        System.out.println("7: " + new Sol().mySqrt(49));
        System.out.println("2: " + new Sol().mySqrt(8));
        System.out.println("0: " + new Sol().mySqrt(0));


    }
}
