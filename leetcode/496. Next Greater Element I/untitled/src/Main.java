import java.util.*;

public class Main {
//    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        TreeSet<Integer> notFound = new TreeSet<>();
//        TreeSet<Integer> tmp = new TreeSet<>();
//        for (int num: nums2)
//        {
//            tmp = new TreeSet<>();
//            map.put(num, -1);
//            notFound.add(num);
//            for (int prev: notFound)
//            {
//                if (prev < num) {
//                    map.put(prev, num);
//                    tmp.add(prev);
//                }
//                else break;
//            }
//            notFound.removeAll(tmp);
//        }
//        int[] answ = new int[nums1.length];
//        for (int i = 0; i < nums1.length; i++)
//            answ[i] = map.get(nums1[i]);
//        return answ;
//    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        LinkedList<Integer> stack = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        stack.add(nums2[0]);
        for (int i = 1; i < nums2.length; i++)
        {
            while (!stack.isEmpty() && stack.getLast() < nums2[i])
                map.put(stack.removeLast(), nums2[i]);
            stack.add(nums2[i]);
        }
        while (!stack.isEmpty())
            map.put(stack.removeLast(), -1);
        int[] answ = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++)
            answ[i] = map.get(nums1[i]);
        return answ;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4})));
    }
}