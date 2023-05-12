import java.util.ArrayList;


public class Main {

    ArrayList<Long> arr;
    int maxZero;
    public long countZero(int zeros)
    {
        if (zeros < maxZero) return arr.get(zeros);
        while (maxZero < zeros)
            arr.add(arr.get(maxZero) + ++maxZero);
        return arr.get(zeros);
    }
    public long zeroFilledSubarray(int[] nums) {
        long answ = 0;
        arr = new ArrayList<>();
        arr.add(0L);
        maxZero = 0;
        int ch;
        int i = 0;
        while (i < nums.length)
        {
            if (nums[i] == 0)
            {
                ch = 0;
                while (i < nums.length && nums[i++] == 0)
                    ch++;
                answ += countZero(ch);
            }
            else i++;
        }
        return answ;
    }
    public static void main(String[] args) {
        System.out.println("6: " + new Main().zeroFilledSubarray(new int[]{1,3,0,0,2,0,0,4}));
        System.out.println("9: " + new Main().zeroFilledSubarray(new int[]{0,0,0,2,0,0}));
        System.out.println("0: " + new Main().zeroFilledSubarray(new int[]{2,10,2019}));
    }
}
//
//1 0 - 1
//2 00 - 2 + 1
//3 000 - 3 + 2 + 1 = 6
//4 0000 - 4 + 3 + 2 + 1 = 10
//5