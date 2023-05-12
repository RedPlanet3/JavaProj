import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public static long[] toLong(String[] str)
    {
        long [] arr = new long[2];
        arr[0] = Long.parseLong(str[0]);
        arr[1] = Long.parseLong(str[1]);
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Long, Long> map = new HashMap<>();
        int count = Integer.parseInt(reader.readLine());
        long df[];
        for (int i = 0; i < count; i++)
        {
            df = toLong(reader.readLine().trim().split(" "));
            map.put(df[0], df[1]);
        }
        String[] re = reader.readLine().trim().split(" ");
        HashMap<Long,Integer> index = new HashMap<>();
        int minInd = Integer.MAX_VALUE;
        for (int i = 0; i < re.length; i++)
        {
            long d = Long.parseLong(re[i]);
            if (!index.containsKey(map.get(d)))
                index.put(map.get(d), i);
            else {
                minInd = Math.min(minInd, i - index.get(map.get(d)));
                index.put(map.get(d), i);
            }
        }
        if (index.size() == re.length) System.out.println(re.length);
        else
            System.out.println(minInd);


        reader.close();
        writer.close();
    }
}
