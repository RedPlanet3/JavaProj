import java.util.Scanner;

public class Solution {

    public static void fullNote(short[] note, Scanner in)
    {
        note[0] = in.nextShort();
        note[1] = in.nextShort();
    }

    public static void sqwere(int min1, int min2, int max1, int max2)
    {
        if (min1 >= max2)
            System.out.println(min1 + " " + (max1 + min2));
        else if (min2 >= max1)
            System.out.println(min2 + " " + (max2 + min1));
        else
            System.out.println(Math.max(max1, max2) + " " + (min2 + min1));
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        short[] note1 = new short[2];
        short[] note2 = new short[2];
        fullNote(note1, in);
        fullNote(note2, in);

        sqwere(Math.min(note1[0], note1[1]),
                Math.min(note2[0], note2[1]),
                Math.max(note1[0], note1[1]),
                Math.max(note2[0], note2[1]));
    }
}
