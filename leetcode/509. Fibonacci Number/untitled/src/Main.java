public class Main {
    public int fib(int n) {
        if (n == 0)
            return 0;
        int first = 1;
        int second = 1;
        int i;
        for (i = 2; i < n; i++)
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
        System.out.println(new Main().fib(0));
        System.out.println(new Main().fib(1));
        System.out.println(new Main().fib(2));
        System.out.println(new Main().fib(3));
        System.out.println(new Main().fib(4));
        System.out.println(new Main().fib(5));
    }
}