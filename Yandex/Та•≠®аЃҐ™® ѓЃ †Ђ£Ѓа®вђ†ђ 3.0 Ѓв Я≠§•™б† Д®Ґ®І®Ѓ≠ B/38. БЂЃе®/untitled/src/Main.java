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
        arr= new int[capacity][2];
    }

    public   void push(int []num)
    {
        arr[finish] = num;
        finish = (finish + 1) % capacity;
    }

    public int[] popFront()
    {
        int []answ = {-5,-5};
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
        return new int[]{-5,-5};
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

    static int [][] moves = {{1,2},{-2,1}, {-1,-2}, {2,1}, {-2,-1}, {1,-2}, {-1,2}, {2,-1}};
    static  int [][] desk;

    public static void fullDesk(int[] start, int n, int m)
    {
        start[0] += 1;
        start[1] += 1;
        QueueWidth1 quel = new QueueWidth1(n * m);
        quel.push(start);

        int startValue;
        int moveValue;
        desk[start[0]][start[1]] = 0;
        while (true)
        {
            start = quel.popFront();
            if (start[0] == -5)
                break;
            startValue = desk[start[0]][start[1]];
            for(int []move: moves)
            {
                moveValue = desk[start[0] + move[0]][start[1] + move[1]];

                if (moveValue == -1)
                {
                    quel.push(new int[]{start[0] + move[0],start[1] + move[1]});
                    desk[start[0] + move[0]][start[1] + move[1]] = 1 + startValue;
                }
            }
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
        int []NMSTQ = toArrayInt(in.readLine().trim().split(" "));
        desk = new int[NMSTQ[0] + 4][NMSTQ[1] + 4];
        int sum = 0;
        int []yx;
        for (int i = 2; i < NMSTQ[0] + 2; i++)
        {
            for (int j = 2; j < NMSTQ[1] + 2; j++)
                desk[i][j] = -1;
        }
        fullDesk(new int[]{NMSTQ[2],NMSTQ[3]}, NMSTQ[0], NMSTQ[1]);
        for (int k = 0; k < NMSTQ[4]; k++)
        {
            yx = toArrayInt(in.readLine().trim().split(" "));
            if (desk[yx[0] + 1][yx[1] + 1] == -1) {
                sum = -1;
                break;
            }
            sum += desk[yx[0] + 1][yx[1] + 1];
        }
        System.out.println(sum);
    }
}