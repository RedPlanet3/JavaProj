public class Main {
    public int climbStairs(int n) {
        int first = 1;
        int second = 1;
        int i;
        for (i = 1; i < n; i++)
        {
            if (i % 2 != 0)
                first = first + second;
            else
                second = first + second;
        }
        if (n == 0)
            return 1;
        if (i % 2 == 0)
            return first;
        return second;
    }
    public static void main(String[] args) {
        System.out.println(new Main().climbStairs(1));
        System.out.println(new Main().climbStairs(2));
        System.out.println(new Main().climbStairs(3));
        System.out.println(new Main().climbStairs(4));
        System.out.println(new Main().climbStairs(5));
        System.out.println(new Main().climbStairs(6));
        System.out.println(new Main().climbStairs(45));
    }
}