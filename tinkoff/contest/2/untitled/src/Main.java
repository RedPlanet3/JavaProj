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
        int nmk[] = toArrayInt(in.nextLine().trim().split(" "));
        System.out.println((int)Math.ceil(nmk[0] * nmk[2] / (double)nmk[1]));
    }
}