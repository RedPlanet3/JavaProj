import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public int search(int[] nums, long target, long sel) {
        int start = 0;
        int finish = nums.length - 1;
        int med;
        if (target < nums[start] * sel) return start;
        if (target > nums[finish] * sel) return nums.length;

        while (start < finish && nums[start] < nums[finish])
        {
            if (target == nums[start] * sel) return start;
            med = (start + finish) / 2;
//            if (nums[med] == target)
//                return med;
            if (target > nums[med] * sel)
                start = med + 1;
            else
                finish = med;

        }
        if (nums[start] * sel == target) return start;
        if (nums[start] * sel < target)
            return start + 1;
        else
            return start;
    }
//    public long[] toSels(long spel, int[] potions)
//    {
//        long [] arr = new long[potions.length];
//        for (int i = 0; i < potions.length; i++)
//            arr[i] = potions[i] * spel;
//        return arr;
//    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        Arrays.sort(potions);
        int [] answ = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            if (!dict.containsKey(spells[i]))
                dict.put(spells[i], potions.length - search(potions, success, spells[i]));
            answ[i] = dict.get(spells[i]);
        }
        return answ;
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println(
                "[4,0,3]\n" +
                Arrays.toString(ds.successfulPairs(
                        new int[]{5,1,3},
                        new int[]{1,2,3,4,5},
                        7)));
        System.out.println(
                "[2,0,2]\n" +
                        Arrays.toString(ds.successfulPairs(
                                new int[]{3,1,2},
                                new int[]{8,5,8},
                                16)));
        System.out.println(
                "[3,46,3]\n" +
                        Arrays.toString(ds.successfulPairs(
                                new int[]{15,37,15},
                                new int[]{31,40,29,19,27,16,25,8,33,25,36,21,7,27,40,24,18,26,32,25,22,21,38,22,37,34,15,36,21,22,37,14,31,20,36,27,28,32,21,26,33,37,27,39,19,36,20,23,25,39,40},
                                600)));
        System.out.println(
                "[89]\n" +
                        Arrays.toString(ds.successfulPairs(
                                new int[]{39},
                                new int[]{32,39,18,34,31,32,24,36,34,24,9,36,37,16,9,20,25,26,33,29,33,18,30,37,18,38,38,38,32,12,36,18,29,5,26,4,11,38,40,15,39,36,25,35,37,5,27,23,30,24,39,9,39,22,36,21,34,24,32,32,37,17,40,36,24,32,39,40,37,19,26,40,32,34,29,26,23,25,18,5,20,26,19,40,16,34,30,29,35,40},
                                195)));
                System.out.println(
                "[89]\n" +
                        Arrays.toString(ds.successfulPairs(
                                new int[]{39},
                                new int[]{
                                        32,39,20,26,19,40,16,34,30,29,35,40
                                },
                                195)));
    }
}


//        5671765041
//        2147483647