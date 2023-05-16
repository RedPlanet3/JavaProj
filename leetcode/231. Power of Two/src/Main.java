import java.util.ArrayList;

public class Main {
    public boolean isPowerOfTwo(int n) {
        if(n <=1)
            return false;
        return ( 1 == (n & (n-1)));
    }

    public static void main(String[] args) {
        Main ds = new Main();
        ArrayList<String> r = new ArrayList<>();
        
        System.out.println("false" + ds.isPowerOfTwo(5));
    }
}
