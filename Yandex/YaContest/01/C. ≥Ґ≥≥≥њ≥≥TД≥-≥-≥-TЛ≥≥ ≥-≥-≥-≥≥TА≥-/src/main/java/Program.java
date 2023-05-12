import java.util.Scanner;
import java.util.ArrayList;

public class Program {

    public static String clean_no(String str)
    {
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
        {
            if ((str.charAt(i) != '-' && str.charAt(i) != '(' && str.charAt(i) != ')'))
                tmp.append(str.charAt(i));
        }
        if(tmp.length() > 7)
            tmp.delete(0, tmp.length() - 10);
        if (tmp.length() > 7 && tmp.substring(tmp.length() - 10,
                tmp.length() - 7).equals("495"))
            tmp.delete(0, tmp.length() - 7);

        return tmp.toString();
    }

    public static void search_tel(ArrayList<String> book, String str)
    {
        for (int i = 0; i < 3; i++)
        {
            if (book.get(i).equals(str))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        ArrayList<String> book = new ArrayList<>();
        String new_tel;
        if (in.hasNextLine()) {
            new_tel = clean_no(in.nextLine());
            for (int i = 0; i < 3; i++) {
                if (in.hasNextLine())
                    book.add(clean_no(in.nextLine()));
            }
            search_tel(book, new_tel);
        }
    }
}
