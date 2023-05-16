
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static int first_letter(String surname)
    {
        if (surname.length() > 0)
            return ((int)surname.charAt(0) - 64) * 256;
        return 0;
    }

    public static int sum_birth_date(String[] words)
    {
        int sum = 0;
        if (words[3].length() > 0 || words[4].length() > 0) {
            String s[] = (words[3] + words[4]).split("");
            for (int i = 0; i < s.length; i++)
                sum += Integer.parseInt(s[i]);
        }
        return sum * 64;
    }
    public static int diff_symbols(String[] words)
    {
        Set<String> countryHashSet = new HashSet<>();
        for (int i = 0; i < 3; i++)
        {
            if (words[i].length() > 0)
                countryHashSet.addAll(Arrays.asList(words[i].split("")));
        }
       return countryHashSet.size();
    }
    public static String dec_to_hex_up_last(int sum)
    {
        String s = Integer.toHexString(sum).toUpperCase();
        if (s.length() >= 3)
            return s.substring(s.length() - 3);
        else
            return s;
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for (int i = 0; i < num; i++)
        {
            String founder = in.next();
            String[] words = founder.split(",");
            System.out.print(dec_to_hex_up_last((diff_symbols(words) + first_letter(words[0]) + sum_birth_date(words))) + " ");
        }
        in.close();
    }
}
