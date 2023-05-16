public class Solution {

    public static void merge()
    {

    }

    public static int[] sortSl(int[] arr, int left, int right)
    {
        int tmp;
        int min1;
        int min2;
        if (right - left == 0)
            return;
        if (right - left == 1)
        {
            if (left > right) {
                tmp = left;
                left = right;
                right = tmp;
            }
        }
        else {
            sortSl(arr, left, (right + left) / 2);
            sortSl(arr, ((right + left) / 2) + 1, right);
            min1 = arr[left];
            min2 = arr[left/2];
            for (int i = left; i < right + 1; i++)
            {
                if (min1 < min2) {
                    arr[i] = min1;

                }
                else
                    arr[i] = min2;
            }

        }
    }

    public static void main(String[] args)
    {}
}
