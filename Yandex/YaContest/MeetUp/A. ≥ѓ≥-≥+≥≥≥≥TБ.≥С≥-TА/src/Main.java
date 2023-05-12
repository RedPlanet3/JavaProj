import java.io.*;

public class Main {

    public static void fullGlass(char[][] glass, char symb, int sl)
    {
        int i = 0;
        while (glass[sl][i] != '\\' && glass[sl][i] != '|' && glass[sl][i] != '/')
            i++;
        i++;
        while (glass[sl][i] != '\\' && glass[sl][i] != '|' && glass[sl][i] != '/')
            glass[sl][i++] = symb;
    }

    public static int[] toInt(String []str)
    {
        int []answ = new int[str.length];
        for (int i = 0; i < str.length; i++)
            answ[i] = Integer.parseInt(str[i]);
        return answ;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int [] nm = toInt(reader.readLine().split(" "));
        char[][] glass = new char[nm[0]][nm[1]];
        for (int i = nm[0] - 1; i > -1; i --)
            glass[i] = reader.readLine().toCharArray();
        int k = Integer.parseInt(reader.readLine());
        String[] sost;
        int start = 1;
        for(int i = 0; i < k; i++)
        {
            sost = reader.readLine().split(" ");
            for (int j = 0; j < Integer.parseInt(sost[1]); j++)
                fullGlass(glass, sost[2].charAt(0), start++);
        }
        for (int i = nm[0] - 1; i > -1; i--) {
            writer.write(glass[i]);
            writer.write("\n");
        }

        reader.close();
        writer.close();
    }

}
