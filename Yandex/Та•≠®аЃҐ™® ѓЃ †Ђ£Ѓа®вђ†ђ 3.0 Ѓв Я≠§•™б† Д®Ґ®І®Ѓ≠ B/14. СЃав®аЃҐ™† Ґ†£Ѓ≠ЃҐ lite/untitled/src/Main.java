import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void push(Integer n)
    {
        arr.add(n);
    }

    public static Integer pop()
    {
        int tmp = 0;
        if (arr.size() != 0) {
            tmp = arr.get(arr.size() - 1);
            arr.remove(arr.size() - 1);
        }
        return tmp;
    }

    public static Integer back()
    {
        if (arr.size() != 0)
            return  (arr.get(arr.size() - 1));
        return 0;
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
        int n = in.nextInt();
        int ch = 1;
        for (int i = 0; i < n; i++)
        {
            push(in.nextInt());
            while (size() > 0 && back() == ch) {
                pop();
                ch++;
            }
        }
        if (arr.size() != 0)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}