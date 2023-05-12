import java.util.Arrays;

public class Main {
    public void rotate(int[] nums, int k) {
        int cur = nums[0];
        int ind = 0;
        int tmp;
        int []visit = new int[nums.length];
        for(int i = 0; i < nums.length; i++)
        {
            while (visit[(ind + k)% nums.length] == 1) {
                ind = (ind + 1) % nums.length;
                cur = nums[ind];
            }
            ind = (ind + k)% nums.length;
            tmp = nums[ind];
            nums[ind] = cur;
            visit[ind] = 1;
            cur = tmp;
        }
    }

    public static void main(String[] args) {
        Main ds = new Main();
        int []arr;

        arr = new int[]{1,2,3,4,5,6,7};
        ds.rotate(arr, 3);
        System.out.println("5,6,7,1,2,3,4\n" + Arrays.toString(arr));

        arr = new int[]{-1,-100,3,99};
        ds.rotate(arr, 2);
        System.out.println("3,99,-1,-100\n" + Arrays.toString(arr));

        arr = new int[]{1};
        ds.rotate(arr, 0);
        System.out.println("1\n" + Arrays.toString(arr));

        arr = new int[]{1,2,3,4,5,6};
        ds.rotate(arr, 3);
        System.out.println("4,5,6,1,2,3\n" + Arrays.toString(arr));
    }
}
