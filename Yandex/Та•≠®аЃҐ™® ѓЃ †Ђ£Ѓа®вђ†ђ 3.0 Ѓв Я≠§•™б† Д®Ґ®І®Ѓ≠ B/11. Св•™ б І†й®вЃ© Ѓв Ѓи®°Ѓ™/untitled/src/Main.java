import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> arr;
    public static void push(int n)
    {
        arr.add(n);
        System.out.println("ok");
    }

    public static void pop()
    {
        if (arr.size() == 0)
            System.out.println("error");
        else
        {
            System.out.println(arr.get(arr.size() - 1));
            arr.remove(arr.size() - 1);
        }
    }

    public static void back()
    {
        if (arr.size() == 0)
            System.out.println(" error");
        else
            System.out.println(arr.get(arr.size() - 1));
    }

    public static void size()
    {
        System.out.println(arr.size());
    }

    public static void clear()
    {
        arr.clear();
        System.out.println("ok");
    }

    public static void exit()
    {
        System.out.println("bye");
        System.exit(0);
    }

    public static void main(String[] args) {
       arr = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String[] enter;
        while (true)
        {
            enter = in.nextLine().trim().split(" ");
            switch (enter[0]) {
                case ("push") -> push(Integer.parseInt(enter[1]));
                case ("pop") -> pop();
                case ("back") -> back();
                case ("size") -> size();
                case ("clear") -> clear();
                case ("exit") -> exit();
            }
        }
    }
}