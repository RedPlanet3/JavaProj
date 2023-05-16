import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;


public class Main2 {
    static BufferedReader in;
    static PrintWriter pw;
    static int capacity = 101;
    static int[] arr = new int[capacity];
    static int start = 0;
    static int finish = 0;
    static StringBuilder answ = new StringBuilder();

    public static  void push_front(int n)
    {
        start = ((start - 1) + capacity) % capacity;
        arr[start] = n;
        answ.append("ok\n");
//        pw.print("ok\n");
    }
    public static  void push_back(int n)
    {
        arr[finish] = n;
        finish = (finish + 1) % capacity;
        answ.append("ok\n");
//        pw.print("ok\n");
    }
    public static  void pop_front()
    {
        if (size() != 0) {
            answ.append(arr[start] + "\n");
//            pw.printf("%d\n", arr[start]);
            start = (start + 1) % capacity;
        }
        else
            answ.append("error\n");
//            pw.print("error\n");
    }

    public static  void pop_back()
    {
        if (size() != 0) {
            finish = ((finish - 1) + capacity) % capacity;
            answ.append(arr[finish] + "\n");
//            pw.printf("%d\n", arr[finish]);
        }
        else
            answ.append("error\n");
//            pw.print("error\n");
    }

    public static  void front()
    {
        if (size() != 0)
            answ.append(arr[start] + "\n");
//            pw.printf("%d\n", arr[start]);
        else
            answ.append("error\n");
//            pw.print("error\n");
    }

    public static  void back()
    {
        if (size() != 0)
            answ.append(arr[((finish - 1) + capacity) % capacity] + "\n");
//            pw.printf("%d\n", arr[((finish - 1) + capacity) % capacity]);
        else
            answ.append("error\n");
//            pw.print("error\n");
    }


    public static  int size()
    {

        if (finish - start < 0)
            return finish + capacity - start;
        return finish - start;
    }

    public static  void myClear()
    {
//        pw.flush();
        answ.append("ok\n");
//        pw.print("ok\n");
        start = finish;
    }

    public static  void exit() throws IOException {

        in.close();
        answ.append("bye\n");
//        pw.print("bye\n");
//        pw.close();
        System.out.println(answ);
        System.exit(0);
    }
    public static void main(String[] args) {
        String [] str;
        try {
            in = new BufferedReader(new FileReader("input.txt"));
            pw = new PrintWriter("output.txt");

            while (true)
            {
                str = in.readLine().trim().split(" ");
                switch (str[0]) {
                    case ("push_front") -> push_front(Integer.parseInt(str[1]));
                    case ("push_back") -> push_back(Integer.parseInt(str[1]));
                    case ("pop_front") -> pop_front();
                    case ("pop_back") -> pop_back();
                    case ("front") -> front();
                    case ("back") -> back();
                    case ("size") -> answ.append(size() + "\n"); //pw.printf("%d\n", size());
                    case ("clear") -> myClear();
                    case ("exit") -> exit();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}