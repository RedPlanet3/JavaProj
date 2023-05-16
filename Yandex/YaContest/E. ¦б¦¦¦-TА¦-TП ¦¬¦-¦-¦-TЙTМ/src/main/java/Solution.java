import java.util.Scanner;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String first = in.nextLine();
        String second = in.nextLine();
        if (first.isEmpty() || second.isEmpty() || first.length() != second.length()) {
            System.out.println("Wrong");
            return;
        }
        HashMap<Character, Integer> arr = new HashMap<>();
        for (int i = 0; i < first.length() ; i++)
        {
            if (arr.containsKey(first.charAt(i)))
                arr.put(first.charAt(i), arr.get(first.charAt(i)) + 1);
            else
                arr.put(first.charAt(i), 1);
        }
        for (int i = 0; i < first.length() ; i++)
        {
            if (arr.containsKey(second.charAt(i))) {
                arr.put(second.charAt(i), arr.get(second.charAt(i)) - 1);
                if (arr.get(second.charAt(i)) < 0) {
                    System.out.println("Wrong");
                    return;
                }
            }
            else {
                System.out.println("Wrong");
                return;
            }
        }
        System.out.println("Good");
    }
}
