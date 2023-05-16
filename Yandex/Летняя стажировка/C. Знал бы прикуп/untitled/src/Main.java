import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int pairs(Map<Integer, ArrayList<int[]>> map, int[] seils)
    {
            int count = 0;
         int start = 0;
         int end = 0;
         while (end < seils.length - 1)
         {
             if (seils[end + 1] < seils[end])
             {
                 if(seils[end] - seils[start] > 0)
                 {
                     if (!map.containsKey(seils[end] - seils[start]))
                         map.put(seils[end] - seils[start], new ArrayList<>());
                     map.get(seils[end] - seils[start]).add(new int[]{start + 1, end + 1});
                     count++;
                 }
                 start = end + 1;
             }
             end++;
         }
         if (seils[start] < seils[end])
         {
             if (!map.containsKey(seils[end] - seils[start]))
                 map.put(seils[end] - seils[start], new ArrayList<>());
             map.get(seils[end] - seils[start]).add(new int[]{start + 1, end + 1});
             count++;
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
        int[] seils = strToInt(reader.readLine().trim().split(" "));

        Map<Integer, ArrayList<int[]>> map = new TreeMap<>(Collections.reverseOrder());
        int count = pairs(map, seils);
        int i = 0;
        System.out.println(count > 2 ? 2 : count);
        if (count == 0) return;
        int [][]answ = new int[count > 2 ? 2 : count][2];

        for (Map.Entry<Integer, ArrayList<int[]>> entry : map.entrySet())
        {
            if (i >= 2) break;
            for (int m[] : entry.getValue()) {
                if (i < 2) answ[i++] = m;
                if (i >= 2) break;
            }
        }
        if (answ.length > 1)
        {
            if (answ[0][0] > answ[1][0]) System.out.println(answ[1][0] + " " + answ[1][1] + "\n" + answ[0][0] + " " + answ[0][1]);
            else System.out.println(answ[0][0] + " " + answ[0][1] + "\n" + answ[1][0] + " " + answ[1][1]);
        }
        else System.out.println(answ[0][0] + " " + answ[0][1]);
        reader.close();
    }
}