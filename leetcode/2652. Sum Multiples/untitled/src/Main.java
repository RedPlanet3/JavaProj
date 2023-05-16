public class Main {
    public static int sumOfMultiples(int n) {
        int sum = 0;
        for (int i = 3; i < n + 1; i++)
        {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0)
                sum += i;
        }
        return sum;
    }

    public static int sumOfMultiples1(int n) {
        return (n / 3) + (n / 7) + (n / 5);
    }

    public static void main(String[] args) {
        System.out.println("21: " + sumOfMultiples(7) + " - " + sumOfMultiples1(7));
        System.out.println("21: " + sumOfMultiples(10) + " - " + sumOfMultiples1(7));
        System.out.println("21: " + sumOfMultiples(9) + " - " + sumOfMultiples1(7));
        System.out.println("21: " + sumOfMultiples(7) + " - " + sumOfMultiples1(7));
        System.out.println("21: " + sumOfMultiples(7) + " - " + sumOfMultiples1(7));
    }
}