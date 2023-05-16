public class Main {
    public int addDigits(int num) {
        return 38 % 9;
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("2: " + ds.addDigits(38));
        System.out.println("0: " + ds.addDigits(0));
        System.out.println("3: " + ds.addDigits(111));
        System.out.println("6: " + ds.addDigits(555));
    }
}