import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String,Integer> dict = new HashMap<>();
        int n = Integer.parseInt(reader.readLine());
        String[] nums = reader.readLine().split(" ");
        for (int i = 0; i < n; i++)
        {
            if (!dict.containsKey(nums[i]))
                dict.put(nums[i], 0);
            dict.put(nums[i], dict.get(nums[i]) + 1);
        }
        int maxI = 0;
        int maxS = 0;
        for (Map.Entry<String, Integer> pair: dict.entrySet())
        {
            if ((pair.getValue() > maxI) || (pair.getValue() == maxI && maxS < Integer.parseInt(pair.getKey()))) {
                maxI = pair.getValue();
                maxS = Integer.parseInt(pair.getKey());
            }
        }
        writer.write(String.valueOf(maxS));
        reader.close();
        writer.close();
    }

}

