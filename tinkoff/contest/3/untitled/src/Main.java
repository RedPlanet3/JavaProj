import java.util.Scanner;
//aabbccddbadd
//aaaabbbbccccdddd
//dbbccca
//abcabac

public class Main {
    public static boolean checkFull(int []abcd)
    {
        for (int i = 0; i < abcd.length; i++)
        {
            if (abcd[i] == 0)
                return false;
        }
        return true;
    }
    //97

    public static boolean moveStart(String str, int []abcd, int start)
    {
        if (abcd[str.charAt(start) - 97] - 1 > 0)
            return true;
        return false;
    }
    public static int moveEnd(String str, int []abcd, int end)
    {
        while (end < str.length() && !checkFull(abcd))
            abcd[str.charAt(end++) - 97] += 1;
        return end;
    }
    public static void fullMin(int startEndMin[], int start, int end)
    {
        if (end - start < startEndMin[1] - startEndMin[0])
        {
            startEndMin[0] = start;
            startEndMin[1] = end;
        }
    }
    public static void findGood(String str)
    {
        int startEndMin[] = new int[2];
        int start = 0;
        int end = 0;
        int []abcd = new int[4];
        end = moveEnd(str, abcd, 0);
        if (!checkFull(abcd))
            System.out.println(-1);
        else
        {
            startEndMin[0] = start;
            startEndMin[1] = end;
            while (start < str.length()) {
                while (start < str.length() && moveStart(str, abcd, start)) {
                    abcd[str.charAt(start) - 97] -= 1;
                    start++;
                }
                fullMin(startEndMin, start, end);
                if (start + 1 < str.length())
                    abcd[str.charAt(start++) - 97] -= 1;
                end = moveEnd(str, abcd, end);
                if (!checkFull(abcd))
                    break;
                fullMin(startEndMin, start, end);
            }
            System.out.println(startEndMin[1] - startEndMin[0]);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (true) {
            in.nextLine();
            findGood(in.nextLine().trim());
//        }
    }
}