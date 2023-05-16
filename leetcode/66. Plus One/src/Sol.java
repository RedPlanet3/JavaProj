import java.util.Arrays;
import java.util.Scanner;

public class Sol {
    public int[] plusOne(int[] digits) {
        int []ret = new int[digits.length + 1];
        int k = 1;
        for (int num: digits)
            ret[k++] = num;
        for (int i = ret.length - 1; i > 0; i--)
        {
            if ((ret[i] + 1) > 9)
                ret[i] = 0;
            else {
                ret[i] = ret[i] + 1;
                return Arrays.copyOfRange(ret, 1, ret.length);
            }
        }
        ret[0] = 1;
        return ret;
    }

    public static int[] toIntArray(String []str)
    {
        if (str[0].equals(""))
            return null;
        int []arr = new int[str.length];
        for (int i = 0; i < str.length; i++)
            arr[i] = Integer.parseInt(str[i].trim());
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int []arr = toIntArray(in.nextLine().trim().split(" "));
        if (arr != null) {
            for (int num : new Sol().plusOne(arr))
                System.out.print(num + " ");
        }
    }
}
