import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Player
{
    private int arr[];
    private int capacity;

    private int start;
    private int finish;
    Player(int cards[], int capacity)
    {
        arr = new int[capacity];
        System.arraycopy(cards, 0, arr, 0, cards.length);
        this.capacity = capacity;
        start = 0;
        finish = cards.length % capacity;
    }
    public void push(int n)
    {
        arr[finish] = n;
        finish = (finish + 1) % this.capacity;
    }

    public int pop()
    {
        int answ = -1;
        if (this.size() != 0) {
            answ = arr[start];
            start = (start + 1) % this.capacity;
        }
        return answ;
    }

    public int front()
    {
        if (this.size() != 0)
            return arr[start];
        return -1;
    }

    public int size()
    {
        if (finish - start < 0)
            return finish + capacity - start;
        return finish - start;
    }
//
//    public void clear()
//    {
//        arr.clear();
//    }
//
//    public void exit()
//    {
//        System.exit(0);
//    }
}
public class Main {


    public static int[] toInt(String s[])
    {
        int answ[] = new int[s.length];
        for (int i = 0; i < 5; i++)
            answ[i] = Integer.parseInt(s[i]);
        return answ;
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Player first  = new Player(toInt(in.nextLine().trim().split(" ")), 11);
        Player second  = new Player(toInt(in.nextLine().trim().split(" ")), 11);
        int ch = 0;

        while (first.size() > 0 && second.size() > 0)
        {
            if (first.front() == 0 && second.front() == 9) {
                first.push(first.pop());
                first.push(second.pop());
            }
            else if (second.front() == 0 && first.front() == 9)
            {
                second.push(first.pop());
                second.push(second.pop());
            }
            else if  (first.front() > second.front() ) {
                first.push(first.pop());
                first.push(second.pop());
            }
            else
            {
                second.push(first.pop());
                second.push(second.pop());
            }
            ch++;
        }
        if (first.size() > 0)
            System.out.print("first ");
        else
            System.out.print("second ");
        System.out.print(ch);
    }
}