import java.io.*;
import java.util.*;

public class Main {

    public static int compare(ArrayList<Long> arr, long []people)
    {
        int plat = 0;
        int man = 0;
        int count = 0;
        while (plat < arr.size() && man < people.length)
        {
            if (people[man] <= arr.get(plat))
            {
                plat++;
                man++;
                count++;
            }
            else
               plat++;
        }
        return count;
    }

    public static ArrayList<Long> ligthPlace(long []bild, long n)
    {
        ArrayList<Long> arr = new ArrayList<>();
        long max = bild[bild.length - 1];
        arr.add(max);
        if (n > 1) {
            for (int i = bild.length - 2; i > -1; i--) {
                if (bild[i] > max)
                {
                    arr.add(bild[i] - max);
                    max = bild[i];
                }
            }
        }
        Collections.sort(arr);
        return arr;
    }
    public static long[] toLong(String []str)
    {
        long []answ = new long[str.length];
        for (int i = 0; i < str.length; i++)
            answ[i] = Long.parseLong(str[i]);
        return answ;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long []nm = toLong(reader.readLine().split(" "));
        long []bild = toLong(reader.readLine().split(" "));
        long []people = toLong(reader.readLine().split(" "));
        Arrays.sort(people);
        System.out.println(compare(ligthPlace(bild, nm[0]), people));

        reader.close();
        writer.close();
    }

}
