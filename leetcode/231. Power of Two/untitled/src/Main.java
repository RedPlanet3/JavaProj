import java.util.BitSet;

public class Main {
    public boolean isPowerOfTwo(int n) {
        BitSet h = new BitSet(n);
        h.get(0);
        return true;
    }
    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("Hello world!" + ds.isPowerOfTwo(5));
    }
}