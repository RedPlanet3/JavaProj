import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer[]> arr;
    public static void push(Integer[] n, Integer[] b)
    {
        arr.add(n);
        arr.add(b);
    }

    public static Integer[] pop()
    {
        Integer[] tmp = new Integer[2];
        if (arr.size() != 0) {
            tmp = arr.get(arr.size() - 1);
            arr.remove(arr.size() - 1);
        }
        return tmp;
    }

    public static Integer[] back()
    {
        if (arr.size() != 0)
            return  (arr.get(arr.size() - 1));
        return new Integer[2];
    }

    public static int size()
    {
        return (arr.size());
    }

    public static void clear()
    {
        arr.clear();
    }

    public static void exit()
    {
        System.exit(0);
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int sizeMemory = in.nextInt();
        HashSet<Integer> mapOs = new HashSet<>();
        int n = in.nextInt();
        arr = new ArrayList<>(n);
        int tmp;
        for (int i = 0; i < n; i++)
        {
            tmp = in.nextInt();
            if (arr.size() == 0 || back()[0] < tmp) {
                push(new Integer[]{tmp, i}, new Integer[]{in.nextInt(), i});
                mapOs.add(i);
            }
            else {
                while (size() > 0 && back()[0] >= tmp) {
//                    pop();
                    mapOs.remove(pop()[1]);
                }
                push(new Integer[]{tmp, i}, new Integer[]{in.nextInt(), i});
                mapOs.add(i);
            }
        }
        System.out.println(mapOs.size());
    }
}