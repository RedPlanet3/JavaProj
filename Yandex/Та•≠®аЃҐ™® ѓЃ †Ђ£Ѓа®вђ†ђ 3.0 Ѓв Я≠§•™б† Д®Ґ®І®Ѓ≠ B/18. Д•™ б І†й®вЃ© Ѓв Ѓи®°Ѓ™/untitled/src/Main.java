//import java.util.LinkedList;
//import java.util.Scanner;
//class Player
//{
//    private int arr[];
//
//    private int capacity;
//
//    private int start;
//    private int finish;
//    Player(int capacity)
//    {
//
//        arr = new int[capacity];
//        this.capacity = capacity;
//        start = 0;
//        finish = 0;
//    }
//    public void push_front(int n)
//    {
//        start = ((start - 1) + capacity) % capacity;
//        arr[start] = n;
//        System.out.println("ok");
//    }
//    public void push_back(int n)
//    {
//        arr[finish] = n;
//        finish = (finish + 1) % this.capacity;
//        System.out.println("ok");
//    }
//
//    public int pop_front()
//    {
//        int answ = -1;
//        if (this.size() != 0) {
//            answ = arr[start];
//            System.out.println(arr[start]);
//            start = (start + 1) % this.capacity;
//        }
//        else
//            System.out.println("error");
//        return answ;
//    }
//
//    public int pop_back()
//    {
//        int answ = -1;
//        if (this.size() != 0) {
//            finish = ((finish - 1) + capacity) % capacity;
//            answ = arr[finish];
//            System.out.println(arr[finish]);
//        }
//        else
//            System.out.println("error");
//        return answ;
//    }
//
//    public int front()
//    {
//        if (this.size() != 0) {
//            System.out.println(arr[start]);
//            return arr[start];
//        }
//        else
//            System.out.println("error");
//        return -1;
//    }
//
//    public int back()
//    {
//        if (this.size() != 0) {
//            System.out.println(arr[((finish - 1) + capacity) % capacity]);
//            return arr[((finish - 1) + capacity) % capacity];
//        }
//        else
//            System.out.println("error");
//        return -1;
//    }
//
//
//    public int size()
//    {
//        if (finish - start < 0) {
////            System.out.println(finish + capacity - start);
//            return finish + capacity - start;
//        }
////        System.out.println(finish - start);
//        return finish - start;
//    }
//
//    public void myClear()
//    {
//        System.out.println("ok");
//        //arr = new int[capacity];
//        start = finish;
//        //finish = 0;
//    }
//
//    public void exit()
//    {
//        System.out.println("bye");
//        System.exit(0);
//    }
//}
//
//public class Main {
//
//    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>();
//        Scanner in = new Scanner(System.in);
//        String[] enter;
//        String tmp;
//
//        Player first  = new Player(100);
//        while (true)
//        {
//
////            enter = in.nextLine().trim().split(" ");
//            switch (in.next()) {
//                case ("push_front"):
//                    first.push_front(in.nextInt());
//                    break;
//                case ("push_back"):
//                    first.push_back(in.nextInt());
//                    break;
//                case ("pop_front"):
//                    first.pop_front();
//                    break;
//                case ("pop_back"):
//                    first.pop_back();
//                    break;
//                case ("front"):
//                    first.front();
//                    break;
//                case ("back"):
//                    first.back();
//                    break;
//                case ("size"):
//                    System.out.println(first.size());
//                    break;
//                case ("clear"):
//                    first.myClear();
//                    break;
//                case ("exit"):
//                    first.exit();
//                    break;
//            }
//        }
//
//
//
//
////        Player first  = new Player(new int[0], 150);
////        while (true)
////        {
////            enter = in.nextLine().trim().split(" ");
////            switch (enter[0]) {
////                case ("push") -> first.push(Integer.parseInt(enter[1]));
////                case ("pop") -> first.pop();
////                case ("front") -> first.front();
////                case ("size") -> System.out.println(first.size());
////                case ("clear") -> first.myClear();
////                case ("exit") -> first.exit();
////            }
////        }
//    }
//
//}