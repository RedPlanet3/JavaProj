import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main3 {

    static int [][] moves = {{0, 1},{1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}, {0,-1}, {-1,0}};
    static int [][] cave;

    public static void firstFullSteps(int[] start)
    {
        cave[start[1]][start[0]] = 0;
        for(int []move: moves)
        {
            int k = 1;
            int val = 1;
//            if (move[0] == -1 && move[1] == 0)
//                val = 0;
            while (cave[start[1] + move[0]*k][start[0] + move[1]*k] == -1) {
                cave[start[1] + move[0] * k][start[0] + move[1] * k] = val;
                k++;
            }
        }
    }

    public static void fullSteps(int[] start, int val)
    {
        cave[start[1]][start[0]] = val;
        for(int []move: moves)
        {
            int k = 1;
            while (cave[start[1] + move[0]* k][start[0] + move[1] * k] == -1 ||
                    cave[start[1] + move[0]* k][start[0] + move[1] * k] > val) {
                cave[start[1] + move[0] * k][start[0] + move[1] * k] = val;
                k++;
            }
        }
    }
    public static int findMin(int y, int x)
    {
        int min = 2147483647;
        for(int []move: moves)
        {
            if (cave[y + move[0]][x + move[1]] > 0)
                min = Math.min(cave[y + move[0]][x + move[1]], min);

        }
        if (min == 2147483647)
            return -1;
        return min;
    }

    public static int[] findStartAndVal(int n, int m)
    {
        int val;
        for (int y = 1; y < n + 1; y++)
        {
            for (int x = 1; x < m + 1; x++)
            {
                if (cave[y][x] == -1) {
                    val = findMin(y, x);
                    if (val != -1)
                        return new int[]{y, x, val + 1};
                }

            }
        }
        return null;
    }
    public static void findStart(int[] start, int n, int m)
    {
//        firstFullSteps(start);
        fullSteps(new int[]{start[0], start[1]}, 1);
        int [] tmp = findStartAndVal(n, m);
        while (tmp != null)
        {
            fullSteps(new int[]{tmp[1], tmp[0]}, tmp[2]);
            tmp = findStartAndVal(n, m);
        }
    }


    public static int[] toArrayInt(String s[])
    {
        int []arr = new int[s.length];
        for (int i = 0; i < s.length; i++)
            arr[i] = Integer.parseInt(s[i]);
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        int []hw = toArrayInt(in.readLine().trim().split(" "));
        cave = new int[hw[0] + 2][hw[1] + 2];
        for (int y = hw[0]; y > 0; y--)
        {
            for (int x = 1; x < hw[1] +1; x++) {
                int symb = in.read();
                if (symb == 'X')
                    cave[y][x] = -2;
                else if (symb == '.')
                    cave[y][x] = -1;
            }
            in.readLine();
        }
        int []start = toArrayInt(in.readLine().trim().split(" "));
        int []finish = toArrayInt(in.readLine().trim().split(" "));
        in.close();
        findStart(start, hw[0], hw[1]);
        System.out.println(cave[finish[1]][finish[0]]);
    }
}