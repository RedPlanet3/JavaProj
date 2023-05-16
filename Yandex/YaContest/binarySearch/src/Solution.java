public class Solution {

    public static int bSearchReq(int left, int rigth, int num, int[] arr)
    {
        int med = (rigth + left) / 2;
        if (arr[med] == num)
            return med;
        if (left == rigth)
            return -1;
        else if (arr[med]  > num)
            return bSearchReq(left, med - 1, num, arr);
        else
            return bSearchReq(med + 1, rigth, num, arr);
    }

    public static int bSearchLoop(int left, int rigth, int num, int[] arr)
    {
        int med;
        while(rigth != left)
        {
            med = (rigth + left) / 2;
            if (arr[med] == num)
                return med;
            if (arr[med]  >= num)
                rigth = med - 1;
            else
                left = med + 1;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] arr = {0, 0, 0, 1, 2, 3, 4, 5, 11, 45, 89, 90};
        System.out.println(bSearchReq(0, arr.length, 5, arr));
        System.out.println(bSearchLoop(0, arr.length, 5, arr));

        System.out.println(bSearchReq(6, arr.length, 1, arr));
        System.out.println(bSearchLoop(6, arr.length, 1, arr));
    }
}
