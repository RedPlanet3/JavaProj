public class Main {
    public int countOdds(int low, int high) {
        return (high - low + (low % 2 == 0 ? 0 : 1) + (high % 2 == 0 ? 0 : 1)) / 2;    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}