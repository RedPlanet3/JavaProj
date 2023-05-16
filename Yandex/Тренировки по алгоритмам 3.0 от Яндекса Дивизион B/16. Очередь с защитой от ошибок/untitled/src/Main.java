import java.util.Scanner;

public class Main {
    static  int capacity = 150;
     static  int arr[] = new int[capacity];
     

     static  int start = 0;
     static  int finish = 0;

    public static  void push(int n)
    {
        arr[finish] = n;
        finish = (finish + 1) % capacity;
        System.out.println("ok");
    }

    public static  int pop()
    {
        int answ = -1;
        if (size() != 0) {
            answ = arr[start];
            System.out.println(arr[start]);
            start = (start + 1) % capacity;
        }
        else
            System.out.println("error");
        return answ;
    }

    public static  int front()
    {
        if (size() != 0) {
            System.out.println(arr[start]);
            return arr[start];
        }
        else
            System.out.println("error");
        return -1;
    }

    public static  int size()
    {
        if (finish - start < 0) {
//            System.out.println(finish + capacity - start);
            return finish + capacity - start;
        }
//        System.out.println(finish - start);
        return finish - start;
    }

    public static  void myClear()
    {
        System.out.println("ok");
        //arr = new int[capacity];
        start = finish;
        //finish = 0;
    }

    public static  void exit()
    {
        System.out.println("bye");
        System.exit(0);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        String[] enter;
//        String tmp;
//        Player first  = new Player(new int[0], 150);
        while (true)
        {
//            enter = in.nextLine().trim().split(" ");
            switch (in.next()) {
                case ("push") -> push(in.nextInt());
                case ("pop") -> pop();
                case ("front") -> front();
                case ("size") -> System.out.println(size());
                case ("clear") -> myClear();
                case ("exit") -> exit();
            }
        }
    }

}