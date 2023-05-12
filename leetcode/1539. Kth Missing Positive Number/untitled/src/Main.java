public class Main {
    public int findKthPositive(int[] arr, int k) {
        int i = 0;
        int ch = 1;
        while (i < arr.length && k > 0)
        {
            if (arr[i] != ch)
                k--;
            else
                i++;
            ch++;
        }
        return ch - 1 + k;
    }
    public static void main(String[] args) {
        System.out.println("9: " + new Main().findKthPositive(new int[]{2,3,4,7,11}, 5));
        System.out.println("6: " + new Main().findKthPositive(new int[]{1,2,3,4}, 2));

    }
}