import java.util.HashSet;

public class Main {
    public static int sumSq(int n)
    {
        int sum = 0;
        while (n > 0)
        {
            sum += Math.pow(n % 10, 2);
            n = n / 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int m;
        while (n != 1)
        {
            n = sumSq(n);
            if (set.contains(n)) return false;
            else set.add(n);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}