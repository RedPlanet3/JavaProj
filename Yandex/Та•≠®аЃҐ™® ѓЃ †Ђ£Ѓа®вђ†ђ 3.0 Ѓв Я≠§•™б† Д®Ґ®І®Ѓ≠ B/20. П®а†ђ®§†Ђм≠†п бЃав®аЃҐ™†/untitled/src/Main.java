import java.util.*;

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
    public static void toArrayListInt(String s[])
    {
        for (int i = 0; i < s.length; i++)
            heap.add(Integer.parseInt(s[i]));
    }

    public static void toHeap(int ind)
    {
        for(int i = ind; i > -1; i--)
            shiftDown(i);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        toArrayListInt(in.nextLine().trim().split(" "));
        int parentFirst = parent(n - 1);
        LinkedList<Integer> sort = new LinkedList<>();
        toHeap(parentFirst);
        while (sort.size() < n)
            sort.addFirst(extract());
        for (int num : sort)
            System.out.print(num + " ");
    }
}