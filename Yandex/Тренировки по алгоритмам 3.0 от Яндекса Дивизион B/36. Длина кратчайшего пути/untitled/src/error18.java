
import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.TreeSet;

class QueueWidth1 {
    int capacity ;
    int arr[];

    int start = 0;
    int finish = 0;
    public QueueWidth1(int cap)
    {
        capacity = cap;
        arr= new int[capacity];
    }

    public   void push(int n)
    {
        arr[finish] = n;
        finish = (finish + 1) % capacity;
    }

    public int popFront()
    {
        int answ = -1;
        if (size() != 0) {
            answ = arr[start];
            start = (start + 1) % capacity;
        }

        return answ;
    }

    public   int front()
    {
        if (size() != 0)
            return arr[start];
        return -1;
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
public class error18 {
    static ArrayList<TreeSet<Integer>> graph;
    static int[] weigth;

    static boolean print = true;
    public static int[] toArrayInt(String s[])
    {
        int []arr = new int[s.length];
        for (int i = 0; i < s.length; i++)
            arr[i] = Integer.parseInt(s[i]);
        return arr;
    }

    public static int bypInBreadth(int[] startEnd, int n)
    {
        if (startEnd[0] == startEnd[1])
            return 0;
        QueueWidth1 quel = new QueueWidth1(n);
        int start = startEnd[0];
        quel.push(start);

        boolean find = false;
        while (!find && print)
        {
            start = quel.popFront();
            print = false;
            for(int num: graph.get(start))
            {
                print = true;
                if (weigth[num] == 0 && weigth[num] != startEnd[0]) {
                    quel.push(num);

                    weigth[num] = weigth[start] + 1;
                    if (num == startEnd[1]) {
                        return weigth[num];
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));

        int n = Integer.parseInt(in.readLine());
        graph = new ArrayList<>();
        weigth = new int[n + 1];

        for (int j = 0; j < n + 1; j++)
            graph.add(new TreeSet<>());
        int[] ab;
        for (int i = 0; i < n; i++) {
            ab = toArrayInt(in.readLine().trim().split(" "));
            for (int j = 0; j < n; j++) {
                if (ab[j] != 0) {
                    graph.get(i + 1).add(j + 1);
                    graph.get(j + 1).add(i + 1);
                }
            }
        }
        int[] startEnd = toArrayInt(in.readLine().trim().split(" "));
        in.close();
        System.out.println(bypInBreadth(startEnd, n));
    }
}