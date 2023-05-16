import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Character, Integer> frequency = new TreeMap<>();
        Scanner in = new Scanner(System.in);
        int maxCount = 0;


        while(in.hasNext())
        {
            for(char ch : in.next().trim().toCharArray())
            {
                if (ch == ' ' || ch == '\n')
                    continue;
                if (!frequency.containsKey(ch)) {
                    frequency.put(ch, 0);
                }
                frequency.put(ch, frequency.get(ch) + 1);
                maxCount = maxCount < frequency.get(ch) ? frequency.get(ch) : maxCount;
            }
        }
        char[][] arr = new char[maxCount][frequency.size()];
        int i = 0;

        for (int j = 0; j < maxCount; j++) {
        i = 0;
            for (Character ch : frequency.keySet()) {

                if (maxCount - frequency.get(ch) <= j)
                    arr[j][i] = '#';
                else
                    arr[j][i] = ' ';
                i++;
            }
        }
        for (char[] d: arr)
            System.out.println(String.valueOf(d));
        for(Character key: frequency.keySet())
            System.out.printf(String.valueOf(key));
    }
}