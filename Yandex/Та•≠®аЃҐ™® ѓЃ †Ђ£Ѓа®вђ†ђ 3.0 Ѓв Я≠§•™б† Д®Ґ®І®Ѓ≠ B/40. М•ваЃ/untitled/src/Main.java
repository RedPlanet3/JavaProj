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
public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] weigth;

    static ArrayList<TreeSet<Integer>> lines;

    static QueueWidth1 quel;

//    static boolean print = true;
    public static int[] toArrayInt(String s[])
    {
        int []arr = new int[s.length];
        for (int i = 0; i < s.length; i++)
            arr[i] = Integer.parseInt(s[i]);
        return arr;
    }


    public static int addStart(int[] startEnd, TreeSet<Integer> finish)
    {
        for (int i = 0; i < graph.get(startEnd[0]).size(); i++)
        {
            if (finish.contains(graph.get(startEnd[0]).get(i)))
                return 0;
            weigth[graph.get(startEnd[0]).get(i)] = 0;
            quel.push(graph.get(startEnd[0]).get(i));
        }
        return 1;
    }

    public static int bypInBreadth(int[] startEnd, int m)
    {

        if (startEnd[0] == startEnd[1]) //
            return 0;
        quel = new QueueWidth1(m);

        TreeSet<Integer> finish = new TreeSet<>(graph.get(startEnd[1]));
        if (addStart(startEnd, finish) == 0)
            return 0;
        int start;
        while (true)
        {
            start = quel.popFront();
            if (start == -1)
                break;
            for(int num: lines.get(start))
            {
                if (weigth[num] == -1) {
                    quel.push(num);
                    weigth[num] = weigth[start] + 1;
                    if (finish.contains(num)) {
                        return weigth[num];
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        graph = new ArrayList<>();
        int n = Integer.parseInt(in.readLine());
        lines = new ArrayList<>();
        for (int j = 0; j < n + 1; j++) {
            graph.add(new ArrayList<>());
        }
        int m = Integer.parseInt(in.readLine());
        for (int j = 0; j < m + 1; j++) {
            lines.add(new TreeSet<>());
        }
        weigth = new int[m + 1];
        for (int i = 1; i < m + 1; i++)
            weigth[i] = -1;

        int[] ab;
        for (int i = 1; i < m + 1; i++)
        {
            ab = toArrayInt(in.readLine().trim().split(" "));
            for (int j = 1; j < ab.length; j++)
                graph.get(ab[j]).add(i);
        }
        ArrayList<Integer> tmp;
        for (int i = 1; i < n + 1; i++) {
             tmp = graph.get(i);
            for (int j = 0; j < tmp.size(); j++) {
                for (int k = 0; k < tmp.size(); k++)
                    lines.get(tmp.get(j)).add(tmp.get(k));
            }
        }

        int[] startEnd = toArrayInt(in.readLine().trim().split(" "));
        in.close();
        System.out.println(bypInBreadth(startEnd, m));
    }
}