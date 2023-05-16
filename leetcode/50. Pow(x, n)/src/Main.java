public class Main {
//    public double myPow(double x, int n) {
//        double answ = x;
//        boolean neg = false;
//        if (n == 0) return 1;
//        if (x == 1.0 || x == 0) return x;
//        if (n < 0) {
//            n *= -1;
//            neg = true;
//        }
//        for (int i = 0; i < n - 1; i++)
//            answ *= x;
//        if (neg) return 1/answ;
//        return answ;
//    }




    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("" + ds.myPow(2.0, -2));
    }
}
