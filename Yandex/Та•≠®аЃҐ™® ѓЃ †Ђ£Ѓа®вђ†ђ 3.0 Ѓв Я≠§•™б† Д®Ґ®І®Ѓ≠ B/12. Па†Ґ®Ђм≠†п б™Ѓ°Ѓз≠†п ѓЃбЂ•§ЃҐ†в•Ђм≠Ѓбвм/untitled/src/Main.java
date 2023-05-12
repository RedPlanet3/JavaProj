import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static ArrayList<Character> arr;
    public static void push(char n)
    {
        arr.add(n);
    }

    public static void pop()
    {
        if (arr.size() != 0)
            arr.remove(arr.size() - 1);
    }

    public static char back()
    {
        if (arr.size() != 0)
            return  (arr.get(arr.size() - 1));
        return '-';
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
        HashMap<Character, Character> map = new HashMap();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        map.put('-', '-');

        Scanner in = new Scanner(System.in);
        char[] enter = in.nextLine().trim().toCharArray();
        for (char c : enter) {
            if (c == '(' ||
                    c == '[' ||
                    c == '{')
                push(c);
            else {
                if (map.get(back()) != c) {
                    System.out.println("no");
                    exit();
                } else
                    pop();
            }
        }
        if (size() != 0)
            System.out.println("no");
        else
            System.out.println("yes");
        }
    }
