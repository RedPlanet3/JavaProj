public class Main {
    public int subtractProductAndSum(int n) {
        int mult = 1;
        int sum = 0;
        int tmp;
        while (n > 0)
        {
            tmp = n % 10;
            sum += tmp;
            mult *= tmp;
            n = n / 10;
        }
        return mult - sum;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}