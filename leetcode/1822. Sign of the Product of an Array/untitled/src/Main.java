public class Main {
    public int arraySign(int[] nums) {
        int neg = 1;
        for(int num: nums)
        {
            if (num == 0) return 0;
            if (num < 0) neg *= -1;
        }
        return neg;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}