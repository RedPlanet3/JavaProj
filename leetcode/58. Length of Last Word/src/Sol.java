import java.util.Scanner;

public class Sol {

    public int lengthOfLastWord(String s) {
        String str[] = s.trim().split(" ");
        return str[str.length - 1].length();
    }


}
