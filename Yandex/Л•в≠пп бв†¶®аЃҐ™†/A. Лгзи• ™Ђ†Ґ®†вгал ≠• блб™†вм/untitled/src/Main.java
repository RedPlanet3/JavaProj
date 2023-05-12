import java.io.*;
import java.util.HashMap;

public class Main {
    public static int rank(int[] alpha, int []rows, int[]text)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < alpha.length; i++)
            map.put(alpha[i], rows[i]);
        int curRow = map.get(text[0]);
        int count = 0;
        for (int word: text)
        {
            if (map.get(word) != curRow)
            {
                count++;
                curRow = map.get(word);
            }
        }
        return count;
    }

    public static int[] strToInt(String[] nums)
    {
        int[] answ = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            answ[i] = Integer.parseInt(nums[i]);
        return answ;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] alpha = strToInt(reader.readLine().trim().split(" "));
        int[] rows = strToInt(reader.readLine().trim().split(" "));
        int lenText = Integer.parseInt(reader.readLine());
        int[] text = strToInt(reader.readLine().trim().split(" "));

        System.out.println(rank(alpha, rows, text));

        reader.close();
    }
}