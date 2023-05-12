public class Main {
    public int reverseBits(int n) {
        int pos = 31;
        int reverse = 0;
        while(pos >= 0 && n != 0){
            if(1 == (n & 1)){
                reverse |= (1 << pos);
            }
            n >>= 1;
            pos--;
        }
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}