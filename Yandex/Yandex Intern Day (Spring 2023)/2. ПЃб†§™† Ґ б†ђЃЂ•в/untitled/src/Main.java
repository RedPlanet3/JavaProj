import java.beans.Introspector;
import java.io.*;
import java.util.*;


public class Main {

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
        HashMap<Long, LinkedList<Long>> map = new HashMap<>();
        int count = Integer.parseInt(reader.readLine());
        long df[];
        for (int i = 0; i < count; i++)
        {
            df = toLong(reader.readLine().trim().split(" "));
            if (!map.containsKey(df[1]))
                map.put(df[1], new LinkedList<>());
            map.get(df[1]).add(df[0]);
        }
        TreeMap<Integer, ArrayList<Long>> sizeCath = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<Long, LinkedList<Long>> entry: map.entrySet())
        {
            int si = entry.getValue().size();
            if (!sizeCath.containsKey(si))
                sizeCath.put(si, new ArrayList<>());
            sizeCath.get(si).add(entry.getKey());
        }



        String[] str = new String[count];
        boolean work = true;
        int start = 0;
            for (ArrayList<Long> f : sizeCath.values()) {
                for (long cath: f)
                {
                    start = 0;
                    while (str[start % count] != null)
                        start++;
                    int diff =(count % map.get(cath).size() + count) / map.get(cath).size();
                    while (map.get(cath).size() > 0) {
                        while (str[start % count] != null)
                            start++;
                        str[start % count] = map.get(cath).getFirst().toString();
                        map.get(cath).removeFirst();
                        start = (start + diff) % count;
                    }
                }
        }
        System.out.println(String.join(" ", str));



        reader.close();
        writer.close();
    }
}