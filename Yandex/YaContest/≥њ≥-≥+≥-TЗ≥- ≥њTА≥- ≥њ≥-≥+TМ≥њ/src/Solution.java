import java.util.Scanner;
import java.util.HashMap;


public class Solution {

    public static void addDic(HashMap<Integer, Integer> dic, int key)
    {
        if (!dic.containsKey(key))
            dic.put(key, 0);
        dic.put(key, dic.get(key) + 1);
    }

    public static int sumPair(HashMap<Integer, Integer> dict)
    {
        int sum = 0;
        for (Integer num: dict.values())
            sum += num - 1;
        return sum;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Integer> row = new HashMap<>();
        HashMap<Integer, Integer> col = new HashMap<>();
        int n = in.nextInt();
        for(int i = 0; i < n; i++)
        {
            addDic(row, in.nextInt());
            addDic(col, in.nextInt());
        }
        System.out.println( (sumPair(row) + sumPair(col)) );
    }
}
