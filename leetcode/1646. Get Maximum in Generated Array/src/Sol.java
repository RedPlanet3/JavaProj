import java.util.Scanner;

public class Sol {
    public int getMaximumGenerated(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 0;
        int max = 0;
        if (n > 0) {
            nums[1] = 1;
            max = 1;
        }

        for (int i = 0; i < n + 1; i++)
        {
            if (2 * i >= 2 && 2 * i <= n) {
                nums[2 * i] = nums[i];
                max = max < nums[2 * i] ? nums[2 * i] : max;
            }
            if ((2 * i + 1) >= 2 && (2 * i + 1) <= n) {
                nums[2 * i + 1] = nums[i] + nums[i + 1];
                max = max < nums[2 * i + 1] ? nums[2 * i + 1] : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println(new Sol().getMaximumGenerated(7));
        System.out.println(new Sol().getMaximumGenerated(2));
        System.out.println(new Sol().getMaximumGenerated(1));
        System.out.println(new Sol().getMaximumGenerated(4));
        System.out.println(new Sol().getMaximumGenerated(0));
//        System.out.println(new Sol().getMaximumGenerated(7));
//        System.out.println(new Sol().getMaximumGenerated(7));
    }
}
