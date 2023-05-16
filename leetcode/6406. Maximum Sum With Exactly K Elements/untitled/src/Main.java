public class Main {
    public static int maximizeSum(int[] nums, int k) {
        int max = nums[0];
        for (int m: nums)
            max = Math.max(m, max);
        int sum = max++;
        for (int i = 0; i < k - 1; i++)
            sum += max++;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("18: " + maximizeSum(new int[]{1,2,3,4,5}, 3 ));
        System.out.println("11:  " + maximizeSum(new int[]{5,5,5}, 2 ));
    }
}