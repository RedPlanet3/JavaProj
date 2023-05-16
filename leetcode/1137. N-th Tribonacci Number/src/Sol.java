public class Sol {
    public int tribonacci(int n) {
        int nums[] = new int[n + 1];
        nums[0] = 0;
        if (n > 0)
            nums[1] = 1;
        if (n > 1)
            nums[2] = 1;
        for (int i = 3; i < n + 1; i++)
            nums[i] = nums[i - 3] + nums[i - 2] + nums[i - 1];
        return nums[n];
    }

    public static void main(String[] args) {
        System.out.println(new Sol().tribonacci(0));
        System.out.println(new Sol().tribonacci(1));
        System.out.println(new Sol().tribonacci(2));
        System.out.println(new Sol().tribonacci(3));
        System.out.println(new Sol().tribonacci(4));
        System.out.println(new Sol().tribonacci(25));
        System.out.println(new Sol().tribonacci(37));
    }
}
