import java.util.Arrays;

public class Main {

    public int minToMax(int[] nums)
    {
        int min = nums.length - 3;
        int sqere = 0;
        while (min > -1)
        {
            if (nums[min + 2] < nums[min] + nums[min + 1])
                sqere = Math.max(nums[min + 2] + nums[min] + nums[min + 1], sqere);
            min--;
        }
        return sqere;
    }
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        return minToMax(nums);
    }

    public static void main(String[] args) {
       Main ds = new Main();
        System.out.println("5: " + ds.minToMax(new int[]{2,1,2}));
//        System.out.println("0: " + ds.minToMax(new int[]{1,2,1,10}));
//        System.out.println("0: " + ds.minToMax(new int[]{3,2,3,4}));
    }
}