public class Main {
    public void moveZeroes(int[] nums) {
        int start = 0;
        int fin = 0;
        while (fin < nums.length)
        {
            if (nums[fin] != 0) {
                nums[start] = nums[fin];
                start++;
            }
            fin++;
        }
        for (int i = start; i < fin; i++)
            nums[i] = 0;
    }

    public static void main(String[] args) {

    }
}
