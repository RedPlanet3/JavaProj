public class Main {
    public static boolean isMonotonic(int[] nums) {
        int i = 1;
        int diff = 0;
        while (i < nums.length && nums[0] == nums[i])
            i++;
        if (i < nums.length) diff = nums[0] - nums[i];
        while (i < nums.length) {
            if (nums[i - 1] != nums[i] && ((nums[i - 1] - nums[i]) <= 0 ^ diff < 0))
                return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("true: " + isMonotonic(new int[]{1,2,2,3}));
        System.out.println("true: " + isMonotonic(new int[]{6,5,4,4}));
        System.out.println("false: " + isMonotonic(new int[]{1,3,2}));

    }
}