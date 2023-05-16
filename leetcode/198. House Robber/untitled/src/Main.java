public class Main {
    public int rob(int[] nums) {
        int []arr = new int[nums.length + 3];
        for (int i = 3; i < nums.length + 3; i++)
            arr[i] = Math.max(arr[i - 2], arr[i - 3]) + nums[i - 3];
        return Math.max(arr[arr.length - 1], arr[arr.length - 2]);
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("4: " + ds.rob(new int[]{1,2,3,1}));
        System.out.println("12: " + ds.rob(new int[]{2,7,9,3,1}));
        System.out.println("2: " + ds.rob(new int[]{2}));
    }
}