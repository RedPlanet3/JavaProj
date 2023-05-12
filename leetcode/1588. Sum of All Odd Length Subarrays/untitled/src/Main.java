import java.util.ArrayList;

public class Main {
    public static int sumOddLengthSubarrays(int[] arr) {
        int[]pref = new int[arr.length + 1];
//        pref[1] = arr[0];
        int sum = 0;
        for (int i = 1; i < pref.length; i++)
            pref[i] = pref[i - 1] + arr[i - 1];
        sum += pref[pref.length - 1];
        for (int i = 3; i < pref.length; i++)
        {
            int k = i;
            while (k > 2) {
                sum += pref[i] - pref[k - 3];
                k -= 2;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("58:" + sumOddLengthSubarrays(new int[]{1,4,2,5,3}));
        System.out.println("3:" + sumOddLengthSubarrays(new int[]{1,2}));
        System.out.println("66:" + sumOddLengthSubarrays(new int[]{10,11,12}));

    }
}