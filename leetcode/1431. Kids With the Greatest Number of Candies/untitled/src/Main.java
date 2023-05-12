import java.util.ArrayList;
import java.util.List;

public class Main {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = candies[0];
        List<Boolean> answ = new ArrayList<>();
        for (int num : candies)
            max = Math.max(max, num);
        for (int i = 0; i < candies.length; i++)
                answ.add(candies[i] + extraCandies >= max);
        return answ;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}