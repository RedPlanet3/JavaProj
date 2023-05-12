
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class S10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        TreeMap<Character, Long> mapa = new TreeMap<>();
        for(int i = 0; i < str.length(); i++)
        {
            if (!mapa.containsKey(str.charAt(i)))
                mapa.put(str.charAt(i), 0L);
            mapa.put(str.charAt(i), mapa.get(str.charAt(i)) + ((i + 1L) * (str.length() - i)));
        }
        for (Map.Entry<Character, Long> node: mapa.entrySet())
            System.out.printf("%c: %d\n", node.getKey(), node.getValue());
    }
}
