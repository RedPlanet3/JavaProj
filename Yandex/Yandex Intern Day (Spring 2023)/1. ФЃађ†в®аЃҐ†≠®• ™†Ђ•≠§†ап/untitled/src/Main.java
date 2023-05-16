
import java.time.DayOfWeek;

import java.util.Scanner;

public class Main {

    public static String[] formStr(int firstNum, int begin, int end)
    {
        int i = 1;
        String[] str = new String[7];
        for (int k = 0; k < 7; k++)
            str[k] = " ";
        while (i < firstNum)
            str[i++ - 1] = "..";
        for (int j = begin; j < end + 1; j++)
            str[i++ - 1] = j > 9 ? String.valueOf(j) : "." + j;
        return str;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        String firstDay = in.nextLine().trim().toUpperCase();
        int firstNum = 0;
        for (int i = 1; i < 8; i++)
        {
            if (DayOfWeek.of(i).toString().equals(firstDay)) {
                firstNum = i;
                break;
            }
        }
        String[] print = formStr(firstNum, 1, 7 - firstNum + 1);
        int begin = 7 - firstNum + 2;
        while (begin <= count) {
            System.out.println(String.join(" ", print));
            print = formStr(0, begin, begin + 6 <= count? begin + 6: count);
            begin += 7;
        }
        System.out.println(String.join(" ", print));
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//
//
//
//        reader.close();
//        writer.close();
//    }
}