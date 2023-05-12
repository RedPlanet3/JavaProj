public class Main {
    public int hammingWeight(int n) {
        int ch = 0;
        while (n != 0) {
            ch++;
            n = n & (n - 1);
        }
        return ch;





//            int count = 0;
//            for(int j=0; j<=31; j++){
//                int bit = (n>>j)&1;
//                if(bit==1){
//                    count = count+1;
//                }
//            }
//            return count;



    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("3: " + ds.hammingWeight(11));
//        System.out.println("31: " + ds.hammingWeight(4294967295));

    }
}