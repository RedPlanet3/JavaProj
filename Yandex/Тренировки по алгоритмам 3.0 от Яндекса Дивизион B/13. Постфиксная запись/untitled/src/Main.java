import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> arr;
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
        arr = new ArrayList<>();
        int sum;
        Scanner in = new Scanner(System.in);
        String[] enter = in.nextLine().trim().split(" ");
        for (String str : enter)
        {
            switch (str) {
                case ("*") -> push(pop() * pop());
                case ("+") -> push(pop() + pop());
                case ("-") -> push( -pop() + pop());
                default -> arr.add(Integer.parseInt(str));
            }
        }
        System.out.println(back());
    }
}
