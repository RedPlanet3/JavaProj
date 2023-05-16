import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void alg2()
    {
        Scanner in = new Scanner(System.in);
        int stK = Integer.parseInt(in.nextLine());
        char[] str = in.nextLine().trim().toCharArray();
        int first = 0;
        int second = 0;
        int k;
        char a = 'a' - 1;
        int maxBeauty = 1;
        for(int i = 0; i < 26; i++)
        {

            first = 0;
            second = 0;
            k = stK;
            a++;
            while (second < str.length)
            {
                if (str[second] == a)
                    second++;
                else if (k > 0) {
                    k--;
                    second++;
                }
                else
                {
                    maxBeauty = maxBeauty < second - first ? second - first : maxBeauty;
                    if (str[first] != a)
                        k++;
                    first++;
                }
            }
            maxBeauty = maxBeauty < second - first ? second - first : maxBeauty;
        }

        maxBeauty = maxBeauty < second - first ? second - first : maxBeauty;

        System.out.println(maxBeauty);
    }

    public static void main(String[] args) {
//        while (true)
            alg2();
    }
}