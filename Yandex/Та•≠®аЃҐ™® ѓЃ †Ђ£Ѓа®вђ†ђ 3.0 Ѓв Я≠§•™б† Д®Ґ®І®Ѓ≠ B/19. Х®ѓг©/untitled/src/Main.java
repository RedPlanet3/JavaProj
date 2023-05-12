import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer> heap = new ArrayList<>();
    public static int parent(int ind)
    {
        return (ind - 1) / 2;
    }
    public static int leftChild(int ind)
    {
        return 2 * ind + 1;
    }
    public static int rigthChild(int ind)
    {
        return 2 * ind + 2;
    }
    public static void shiftUp(int ind)
    {
        int parent;
        int child;
        while (ind > 0 && heap.get(parent(ind)) < heap.get(ind)) {
            parent = heap.get(parent(ind));
            child = heap.get(ind);
            heap.set(parent(ind), child);
            heap.set(ind, parent);
            ind = parent(ind);
        }
    }
    public static void shiftDown(int ind)
    {
        int tmp;
        while (true) {
            int maxI = ind;
            int leftI = leftChild(ind);
            if (leftI < heap.size() && heap.get(leftI) > heap.get(maxI))
                maxI = leftI;
            int rigth = rigthChild(ind);
            if (rigth < heap.size() && heap.get(rigth) > heap.get(maxI))
                maxI = rigth;
            if (ind != maxI) {
                tmp = heap.get(ind);
                heap.set(ind, heap.get(maxI));
                heap.set(maxI, tmp);
                ind = maxI;
            }
            else
                break;
        }

    }
    public static void insert(int n)
    {
        heap.add(n);
        shiftUp(heap.size() - 1);
    }
    public static int extract()
    {
        int res = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.set(heap.size() - 1, res);
        heap.remove(heap.size() - 1);
        shiftDown(0);
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++)
        {
            if (in.next().equals("0"))
                insert(in.nextInt());
            else
                System.out.println(extract());
        }
    }
}