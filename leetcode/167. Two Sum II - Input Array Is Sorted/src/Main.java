import java.util.Arrays;

public class Main {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int tmp;
        while (left < right)
        {
            if (numbers[left] + numbers[right] == target) break;
            tmp = target - numbers[right];
            while (numbers[left] < tmp) left++;
            if (numbers[left] + numbers[right] == target) break;
            tmp = target - numbers[left];
            while (numbers[right] > tmp) right--;
        }
        return new int[]{left + 1, right + 1};
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("[1,2]:\n" + Arrays.toString(ds.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("[1,3]:\n" + Arrays.toString(ds.twoSum(new int[]{2 ,3, 4}, 6)));
        System.out.println("[1,2]:\n" + Arrays.toString(ds.twoSum(new int[]{-1 , 0 }, -1)));

    }
}
