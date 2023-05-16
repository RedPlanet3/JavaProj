import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class QueueWidth {
    int capacity ;
    int arr[][];

    int start = 0;
    int finish = 0;
    public QueueWidth(int cap)
    {
        capacity = cap;
        arr= new int[capacity][2];
    }

    public   void push(int y, int x)
    {
        arr[finish] = new int[]{y,x};
        finish = (finish + 1) % capacity;
    }

    public int[] popFront()
    {
        int[] answ = null;
        if (size() != 0) {
            answ = arr[start];
            start = (start + 1) % capacity;
        }

        return answ;
    }

    public int[] front()
    {
        if (size() != 0)
            return arr[start];
        return null;
    }

    public   int size()
    {
        if (finish - start < 0) {
            return finish + capacity - start;
        }
        return finish - start;
    }

    public   void myClear()
    {
        start = finish;
    }

    public   void exit()
    {
        System.exit(0);
    }

}


public class Main2 {

    static int [][] moves = {{0, 1},{1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}, {0,-1}, {-1,0}};
    static int [][] cave;
    static QueueWidth queueCave;

    public static void firstFullSteps(int[] start)
    {
        cave[start[1]][start[0]] = 0;
        for(int []move: moves)
        {
            int k = 1;
            int val = 1;
            if (move[0] == 1 && move[1] == 0)
                val = 0;
            while (cave[start[1] + move[0]*k][start[0] + move[1]*k] == -1) {
                cave[start[1] + move[0] * k][start[0] + move[1] * k] = val;
                queueCave.push(start[1] + move[0] * k, start[0] + move[1] * k);
                k++;
            }
        }
    }

    public static void fullSteps(int[] start, int val)
    {
        if (cave[start[1]][start[0]] != 0)
            cave[start[1]][start[0]] = val;
        for(int []move: moves)
        {
            int k = 1;
            while (cave[start[1] + move[0]* k][start[0] + move[1] * k] == -1 ||
                    cave[start[1] + move[0]* k][start[0] + move[1] * k] > val) {
                cave[start[1] + move[0] * k][start[0] + move[1] * k] = val;
                queueCave.push(start[1] + move[0] * k, start[0] + move[1] * k);
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

//    public static int[] findStartAndVal(int n, int m)
//    {
//        int val;
//        for (int y = 1; y < n + 1; y++)
//        {
//            for (int x = 1; x < m + 1; x++)
//            {
//                if (cave[y][x] == -1) {
//                    val = findMin(y, x);
//                    if (val != -1)
//                        return new int[]{y, x, val + 1};
//                }
//
//            }
//        }
//        return null;
//    }

    public static int findStartAndVal(int [] tmp) {

        int val = findMin(tmp[0], tmp[1]);
        if (val != -1)
            val = val + 1;
//            return new int[]{tmp[0], tmp[1], val + 1};}
        return val;
    }
    public static void findStart(int[] start, int n, int m)
    {
        queueCave.push(start[1], start[0]);
//        cave[start[1]][start[0]] = 0;
        firstFullSteps(start);
//        fullSteps(new int[]{start[0], start[1]}, 1);
        int [] tmp = queueCave.popFront();
        int val = findStartAndVal(tmp);
        while (true)
        {
            while (tmp!= null && val == -1) {
                tmp = queueCave.popFront();
                if (tmp != null) val = findStartAndVal(tmp);
            }
            if (val != -1)
                fullSteps(new int[]{tmp[1], tmp[0]}, val);
            else
                break;
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
        queueCave = new QueueWidth(hw[0] * hw[1]);
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