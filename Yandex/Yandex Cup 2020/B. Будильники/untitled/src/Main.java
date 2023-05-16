
import java.util.Scanner;
import java.util.TreeSet;

//6 5 10
//        1 2 3 4 5 6

public class Main {
    public static int[] readNums(String[] dan)
    {
        int[] arr = new int[dan.length];
        int i = 0;
        for(String str: dan)
            arr[i++] = Integer.parseInt(str);
        return arr;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ch;
        int timeWakeUp = 0;

        int[] dan = readNums(in.nextLine().trim().split(" "));
        TreeSet<Integer> al = new TreeSet<Integer>();
        for(String str: in.nextLine().trim().split(" "))
            al.add(Integer.parseInt(str));
        ch = 0;
        while (ch < dan[2])
        {
            timeWakeUp = al.first();
            al.remove(timeWakeUp);
            al.add(timeWakeUp + dan[1]);
            ch++;
        }
        System.out.printf(String.valueOf(timeWakeUp));
    }
}