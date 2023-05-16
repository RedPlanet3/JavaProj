import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int stK = in.nextInt();
        int k = stK;
        HashMap<Character, ArrayList<Integer>> dict = new HashMap<>();
        int i = 0;
        int maxBeauty = 0;
        int tmpBeauty = 1;
        int raz = 0;
        int start;
        for (char ch : in.next().toCharArray())
        {
            if (!dict.containsKey(ch)) {
                dict.put(ch, new ArrayList<>());
                dict.get(ch).add(-1);
            }
            dict.get(ch).add(i++);
        }
        for(Character key: dict.keySet())
        {
            start = 1;
            tmpBeauty = 1;
            while (start < dict.get(key).size()) {
                tmpBeauty = 1;
                k = stK;
                for (int l = start; l < dict.get(key).size(); l++) {
                    raz = dict.get(key).get(l) - dict.get(key).get(l - 1) - 1;
                    if (raz >= 0 && raz <= k) {
                        k -= raz;
                        tmpBeauty += dict.get(key).get(l - 1) > -1 ? raz + 1 : raz;
                    } else {
                        tmpBeauty = dict.get(key).get(start - 1) + k < i ? tmpBeauty + k :  i - dict.get(key).get(start - 1);
                        k = 0;
                        break;
                    }
                }
                start++;
                if (k >= 0) {
                    tmpBeauty = dict.get(key).get(start - 1) + k < i ? tmpBeauty + k : i - dict.get(key).get(start - 1);
                    k = 0;
                }
                maxBeauty = maxBeauty < tmpBeauty ? tmpBeauty : maxBeauty;


            }
            if (k >= 0) {
                tmpBeauty = dict.get(key).get(start - 1) + k < i ? tmpBeauty + k : i - dict.get(key).get(start - 1);
                maxBeauty = maxBeauty < tmpBeauty ? tmpBeauty : maxBeauty;
            }
        }
        System.out.println(maxBeauty);
    }
}