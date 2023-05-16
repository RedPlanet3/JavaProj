import java.io.*;
import java.util.HashMap;
import java.util.HashSet;


public class Main {

    public static int med(int[] zeroOne)
    {
        if (zeroOne[0] > zeroOne[1])
            return 0;
        if (zeroOne[1] > zeroOne[0])
            return 1;
        return -1;
    }

    public static int retL(char[] s, int r)
    {
        int[] zeroOne = new int[2];
        zeroOne[s[r] - '0'] += 1;
        for (int i = r - 1; i > -1; i--)
        {
            zeroOne[s[i] - '0'] += 1;
            if (s[r] - '0' == med(zeroOne))
                return i + 1;
        }
        return -1;
    }


    public static int[] pref(char[] s)
    {
        int []pref = new int[s.length];
        pref[0] = -1;
        int[] zeroOne = new int[2];
        zeroOne[s[0] - '0'] += 1;
        for (int i = 1; i < s.length - 1; i++)
        {
            zeroOne[s[i] - '0'] += 1;
            pref[i] = med(zeroOne);
        }
        return pref;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        char[] s = reader.readLine().toCharArray();

        for (int i = 0; i < s.length; i++)
            System.out.print(retL(s, i) + " ");



        reader.close();
        writer.close();
    }
}
