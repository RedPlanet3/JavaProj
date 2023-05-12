public class Main {
    public int search(int[] nums, int target) {
        int start = 0;
        int finish = nums.length - 1;
        int med;
        while (start < finish) {
            med = (start + finish) / 2;
            if (nums[med] == target)
                return med;
            if (target < nums[med])
                finish = med - 1;
            else
                start = med + 1;
        }
        if (nums[start] == target) return start;
        if (nums[finish] == target) return finish;
        return -1;
    }
    public static void main(String[] args) {
        Main ds = new Main();
//        System.out.println("4: " + ds.search(new int[]{-1,0,3,5,9,12}, 9));
//        System.out.println("-1: " + ds.search(new int[]{-1,0,3,5,9,12}, 2));
//        System.out.println("0: " + ds.search(new int[]{5}, 5));
        System.out.println("-1: " + ds.search(new int[]{-1,0,3,5,9,12}, 0));
    }
}