

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main3 {

    public static int rbin(ArrayList<Integer> arr, int num, int left, int right)
    {
        int med;
        if (num <= arr.get(left))
            return 0;
        if (num > arr.get(right))
            return arr.size();
        while (left < right)
        {
            med = (left + right) / 2;
            if (arr.get(med) >= num)
                right = med;
            else
                left = med + 1;
        }
        return left;
    }
    public static Integer[] toInt(String s[])
    {
        Integer answ[] = new Integer[s.length];
        for (int i = 0; i < s.length; i++)
            answ[i] = Integer.parseInt(s[i]);
        return answ;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        int p;
//        TreeSet<Integer> diogoSet = new TreeSet<>();
        TreeSet<Integer> diogoSet = null;
        File out = new File("output.txt");
        ArrayList<Integer> arr;
        HashMap<Integer, Integer> friends= new HashMap<>();
        try(BufferedReader in = new BufferedReader(new FileReader("input.txt")))
        {
            int n = Integer.parseInt(in.readLine());
            diogoSet = new TreeSet<>(Arrays.asList(toInt(in.readLine().trim().split(" "))));
            arr = new ArrayList<>(diogoSet);
            int k = Integer.parseInt(in.readLine());

            PrintWriter pw = new PrintWriter(out);
            for(int num : toInt(in.readLine().trim().split(" "))) {
                if (!friends.containsKey(num))
                    friends.put(num, rbin(arr, num, 0, diogoSet.size() - 1));
                pw.println(friends.get(num));
            }
            pw.close();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }






//        int p;
//        TreeSet<Integer> diogoSet = new TreeSet<>();
//        ArrayList<Integer> arr = new ArrayList<>(diogoSet);
//        HashMap<Integer, Integer> friends= new HashMap<>();
//
//        int n = in.nextInt();
//        for (int i = 0; i < n; i++)
//            diogoSet.add(in.nextInt());
//        int k = in.nextInt();
//        for(int i = 0; i < k; i++) {
//            p = in.nextInt();
//            if (!friends.containsKey(p))
//                friends.put(p, rbin(arr, p, 0, diogoSet.size() - 1));
//            System.out.println(friends.get(p));
//        }
    }
}