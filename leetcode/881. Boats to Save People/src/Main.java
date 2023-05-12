import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        int small = 0;
        int big = people.length - 1;
        Arrays.sort(people);
        while (small < big)
        {
            if (people[small] + people[big] > limit)
                big--;
            else {
                small++;
                big--;
            }
            boats++;
        }
        if (big == small) boats++;
        return boats;
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("1: " + ds.numRescueBoats(new int[]{1,2}, 3));
        System.out.println("3: " + ds.numRescueBoats(new int[]{3,2,2,1}, 3));
        System.out.println("4: " + ds.numRescueBoats(new int[]{3,5,3,4}, 5));
    }
}
