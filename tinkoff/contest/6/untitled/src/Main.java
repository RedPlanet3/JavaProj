import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Main {
    public static int[] toArrayInt(String s[])
    {
        if (s[0].equals(""))
            return null;
        int []arr = new int[s.length];
        for (int i = 0; i < s.length; i++)
            arr[i] = Integer.parseInt(s[i]);
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int []nSum = toArrayInt(in.nextLine().trim().split(" "));
        int [][]stud = new int[nSum[0]][2];
        for (int i = 0; i < nSum[0]; i++)
            stud[i] = toArrayInt(in.nextLine().trim().split(" "));
        Arrays.sort(stud);
        int med = stud.length / 2;
        for (int i = 0; i < )
    }
}