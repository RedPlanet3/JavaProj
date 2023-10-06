import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static int min_need(ArrayList<Integer> nums, int n)
    {
        int count = count_digit(nums.get(n - 1));
        int min = nums.get(n - 1);
        if (min == 0)
            return 0;
        int i = n - 1;
        while (i > 0)
        {
            if (count_digit(nums.get(i - 1)) < count || nums.get(i - 1) == 0) {
                break;
            }
            else
                min = nums.get(i - 1);
            i--;
        }
        nums.remove(i);
        return min;
    }

    public static int count_digit(int num)
    {
        int ch = 1;
        while (true)
        {
            if (num / 10 != 0)
                ch++;
            else
                break;
            num = num / 10;
        }
        return ch;
    }

    public static int[] change_num(int num)
    {
        int sum;
        if (num == 0)
            return new int[]{0, 0};
        StringBuilder tmp = new StringBuilder(Integer.toString(num));
        tmp.replace(0,1,"9");

        sum = Integer.parseInt(tmp.toString()) - num;
        if (tmp.length() == 1)
            return new int[]{0, sum};
        return new int[]{Integer.parseInt(tmp.substring(1)), sum};
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        int sum = 0;
        int sum_tmp = 0;
        int tmp_num[] = new int[]{};

        for (int i = 0; i < n; i++) {
            nums.add(in.nextInt());
            sum += nums.get(i);
        }
        Collections.sort(nums);

        for (int i = 0; i < k; i++)
        {
            tmp_num =  change_num(min_need(nums, n));
            sum_tmp += tmp_num[1];
            nums.add(tmp_num[0]);
            Collections.sort(nums);
        }
        System.out.println(sum_tmp);
    }
}
