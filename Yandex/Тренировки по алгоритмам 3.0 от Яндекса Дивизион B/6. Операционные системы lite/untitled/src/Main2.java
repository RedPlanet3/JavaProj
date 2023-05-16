import java.util.*;

public class Main2 {
    public static void prog()
    {
        Scanner in = new Scanner(System.in);
        TreeMap<Integer, Integer> mapOs = new TreeMap<>();

        int n = in.nextInt();
        int os = in.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < os + 1; i++)
        {
            int open = in.nextInt();
            int close = in.nextInt();
            if (open == close)
                set.add(-i);
            else
                mapOs.put(open, i);
            mapOs.put(close, -i);
        }

        int tmp = 0;
        int ch = 0;
        ArrayList<Integer> curr = new ArrayList<>();


        for (int val: mapOs.values())
        {
            if (tmp == 0 && val > 0) {
                if (curr.size() == 0 || val > curr.get(curr.size() - 1)) {
                    curr.add(val);
                    tmp = val;
                }

            }
            else if (tmp == -val) {
                ch++;
                tmp = 0;
                curr.remove(curr.size() - 1);

            }
            else if (val > tmp) {
                if (val > curr.get(curr.size() - 1)) {
                    curr.add(val);
                    tmp = val;
                }
            }
            else if (val < 0 && (-val > tmp || tmp == 0)  && set.contains(val)) {
                ch++;
                tmp = 0;

            }
            else if (tmp != 0 && -val > tmp) {
                tmp = 0;
                curr.remove(curr.size() - 1);

            }
            else if(curr.size() != 0 && -val == curr.get(curr.size() - 1))
                curr.remove(curr.size() - 1);

        }
        System.out.println(ch);
    }

    public static void main(String[] args) {
        while (true)
        {
            prog();
        }

    }
}