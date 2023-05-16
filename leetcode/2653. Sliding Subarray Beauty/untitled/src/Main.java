import java.util.*;

public class Main {
    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
//        TreeSet<Integer> ds = new TreeSet<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int [] answ = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++)
            pq.add(nums[i]);
        int l = 0;

        for (int i = k; i < nums.length + 1; i++)
        {
            PriorityQueue<Integer> tmp = new PriorityQueue<>(pq);
            int ch = 0;
            for (int h = 1; h < x; h++)
                tmp.poll();
            answ[l] = tmp.peek();
            if (k < nums.length) {
                pq.add(nums[k]);
                pq.remove(nums[i - k]);
            }
            l++;
        }
        return answ;
    }

    public static void main(String[] args) {
        System.out.println("[-1,-2,-2]\n" + Arrays.toString(getSubarrayBeauty(new int[]{1,-1,-3,-2,3}, 3, 2)));
        System.out.println("[-1,-2,-3,-4]\n" + Arrays.toString(getSubarrayBeauty(new int[]{-1,-2,-3,-4,-5}, 2, 2)));
        System.out.println("[-3,0,-3,-3,-3]\n" + Arrays.toString(getSubarrayBeauty(new int[]{-3,1,2,-3,0,-3}, 2, 1)));
    }
}