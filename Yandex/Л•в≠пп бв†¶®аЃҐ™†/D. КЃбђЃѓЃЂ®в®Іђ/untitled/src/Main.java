import java.io.*;
import java.util.*;

public class Main {

    public static int[] strToInt(String[] nums)
    {
        int[] answ = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            answ[i] = Integer.parseInt(nums[i]);
        return answ;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nCountryes = Integer.parseInt(reader.readLine());
        int[] moneyCount = strToInt(reader.readLine().trim().split(" "));
        int[] eduCount = strToInt(reader.readLine().trim().split(" "));
        int[] parentCount = strToInt(reader.readLine().trim().split(" "));

        int nMans = Integer.parseInt(reader.readLine());
        int[] moneyMans = strToInt(reader.readLine().trim().split(" "));
        int[] eduMans = strToInt(reader.readLine().trim().split(" "));
        int[] parentMans = strToInt(reader.readLine().trim().split(" "));

        int[] answ = new int[nMans];

        Set<Integer> notEdu = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nCountryes; i++) {
            if (eduCount[i] == 0) notEdu.add(i);
            map.put(i, moneyCount[i]);
        }
        Set<Integer> parents = new HashSet<>();
        for (int i = 0; i < nCountryes; i++)
            if (parentCount[i] == 1) parents.add(i + 1);


















        TreeMap<Integer, Integer> without = new TreeMap<>();
        TreeSet<Integer> parents = new TreeSet<>();
        for (int i = 0; i < nCountryes; i++)
            if (parentCount[i] == 1) parents.add(i + 1);
        for (int i = 0; i < nCountryes; i++)
            if (eduCount[i] == 0) without.put(i, moneyCount[i]);
        int l = 0;
        for (int i = 0; i < nMans; i++)
        {
            if (parents.contains(parentMans[i])) l = parentMans[i];
            if (eduMans[i] == 0)
            {
                for (Map.Entry<Integer, Integer> entry: without.entrySet())
                {
                    if (l > 0 && l < entry.getKey()) {
                        answ[i] = l;
                        break;
                    }
                    if (entry.getValue() <= moneyMans[i])
                    {
                        answ[i] = entry.getKey() + 1;
                        break;
                    }
                }
            }
            else {
                for (int j = 0; j < nCountryes; j++) {
                    if (moneyMans[i] >= moneyCount[j]) {
                        answ[i] = j + 1;
                        break;
                    }
                }
            }
            if (parents.contains(parentMans[i])) {
                if (answ[i] > 0) answ[i] = Math.min(parentMans[i], answ[i]);
                else answ[i] = parentMans[i];
            }
        }

        for(int num: answ)
            System.out.print(num + " ");

        reader.close();
    }}