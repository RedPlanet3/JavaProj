
class Heap
{
    int [] heap;
    int size;
    Heap(int[] stones)
    {
        heap = new int[stones.length];
        size = 0;
        for (int i = 0; i < stones.length; i++)
            addStone(stones[i]);
    }
    public int removeMax() //size--
    {
        int answ = heap[0];
        if (size > 0) {
            heap[0] = heap[size - 1];
            size--;
        }
        siftDown();
        return answ;
    }
    public void addStone(int stone) //size++
    {
        size++;
        heap[size - 1] = stone;
        siftUp();
    }

    public int[] changePlace(int child, int[] start)
    {
        int tmp;

        tmp = heap[child];
        heap[child] = heap[start[0]];
        heap[start[0]] = tmp;
        start[0] = child;
        return new int[]{getLeftChild(start[0]), getRightChild(start[0])};
    }

    public void siftDown()
    {
        int []start = new int[]{0};
        int []leftAndRight = new int[2];
        leftAndRight[0] = getLeftChild(start[0]);
        leftAndRight[1] = getRightChild(start[0]);
        int tmp;
        while (true)
        {
            if (leftAndRight[0] < size && leftAndRight[1] < size)
            {
                if(heap[leftAndRight[0]] >= heap[leftAndRight[1]] && heap[start[0]] <= heap[leftAndRight[0]])
                    leftAndRight = changePlace(leftAndRight[0], start);
                else if(heap[leftAndRight[1]] > heap[leftAndRight[0]] && heap[start[0]] <= heap[leftAndRight[1]])
                    leftAndRight = changePlace(leftAndRight[1], start);
                else
                    break;
            }
            else if (leftAndRight[0] < size && heap[start[0]] <= heap[leftAndRight[0]])
                leftAndRight = changePlace(leftAndRight[0], start);
            else if (leftAndRight[1] < size && heap[start[0]] <= heap[leftAndRight[1]])
                leftAndRight = changePlace(leftAndRight[1], start);
            else
                break;
        }
    }

    public void siftUp()
    {
        int child = size - 1;
        int parent = getParent(child);
        int tmp;
        while (parent > -1 && heap[parent] < heap[child])
        {
            tmp = heap[child];
            heap[child] = heap[parent];
            heap[parent] = tmp;
            child = parent;
            parent = getParent(child);
        }
    }

    public int getParent(int child)
    {
        return (child - 1) / 2;
    }

    public int getLeftChild(int parent)
    {
        return parent * 2 + 1;
    }

    public int getRightChild(int parent)
    {
        return parent * 2 + 2;
    }
}

public class Main {

    public int lastStoneWeight(int[] stones) {
        Heap heap = new Heap(stones);
        int diff;
        while (heap.size > 1)
        {
            diff = Math.abs(heap.removeMax() - heap.removeMax());
            if (diff != 0)
                heap.addStone(diff);
        }
        if (heap.size > 0)
            return heap.removeMax();
        return 0;
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("1: " + ds.lastStoneWeight(new int[]{2,7,4,1,8,1}));
        System.out.println("1: " + ds.lastStoneWeight(new int[]{1}));
        System.out.println("0: " + ds.lastStoneWeight(new int[]{1, 1}));
        System.out.println("1: " + ds.lastStoneWeight(new int[]{8,8,6,3,7,4,7}));

    }
}

//0 1 2 3 4 5 6 7
