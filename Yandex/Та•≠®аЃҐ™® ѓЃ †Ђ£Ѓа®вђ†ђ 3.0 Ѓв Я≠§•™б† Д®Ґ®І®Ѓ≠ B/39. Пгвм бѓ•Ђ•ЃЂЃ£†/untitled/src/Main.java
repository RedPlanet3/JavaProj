import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class QueueWidth1 {
    int capacity ;
    int arr[][];

    int start = 0;
    int finish = 0;
    public QueueWidth1(int cap)
    {
        capacity = cap;
        arr= new int[capacity][3];
    }

    public   void push(int []num)
    {
        arr[finish] = num;
        finish = (finish + 1) % capacity;
    }

    public int[] popFront()
    {
        int []answ = {-5,-5,-5};
        if (size() != 0) {
            answ = arr[start];
            start = (start + 1) % capacity;
        }

        return answ;
    }

    public   int[] front()
    {
        if (size() != 0)
            return arr[start];
        return new int[]{-5,-5,-5};
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
public class Main {

    static int [][] moves = {{1,0,0},{-1,0,0}, {0,1,0}, {0,-1,0}, {0,0,1}, {0,0,-1}};
    static int [][][] cave;
    public static int bypInBreadth(int[] start, int n)
    {
        if (start[0] == n)
            return 0;
        QueueWidth1 quel = new QueueWidth1(n * n * n);
        quel.push(start);
        boolean find = false;
        int startValue;
        int moveValue;
        while (true)
        {
            start = quel.popFront();
            startValue = cave[start[0]][start[1]][start[2]];
            for(int []move: moves)
            {
              moveValue = cave[start[0] + move[0]][start[1] + move[1]][start[2] + move[2]];

                if (moveValue == -1)
                {
                    quel.push(new int[]{start[0] + move[0],start[1] + move[1],start[2] + move[2]});
                    cave[start[0] + move[0]][start[1] + move[1]][start[2] + move[2]] = 1 + startValue;
                    if ((start[0] + move[0]) >= n)
                        return cave[start[0] + move[0]][start[1] + move[1]][start[2] + move[2]];
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        int n = Integer.parseInt(in.readLine());
        cave = new int[n + 2][n + 2][n + 2];
        int []start = new int[3];

        for(int z = n; z > 0; z--)
        {
            in.readLine();
            for (int y = 1; y < n + 1; y++)
            {
                for (int x = 1; x < n +1; x++) {
                    int symb = in.read();
                    if (symb == '#')
                        cave[z][y][x] = -2;
                    else if (symb == '.')
                        cave[z][y][x] = -1;
                    else
                    {
                        cave[z][y][x] = 0;
                        start[0] = z;
                        start[1] = y;
                        start[2] = x;
                    }
                }
                in.readLine();
            }
        }
        System.out.println(bypInBreadth(start, n));
    }
}