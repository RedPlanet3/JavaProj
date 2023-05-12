public class Sol {
    public boolean divisorGame(int n) {
////        boolean []game = new boolean[n + 1];
//
//        game[1] = false;
//        game[2] = true;
//        game[3] = false;
//        game[4] = true;
//        game[5] = false;
//        game[6] = true;
        return (n % 2) == 0;
    }

    public static void main(String[] args) {
        System.out.println("true: " + new Sol().divisorGame(2));
        System.out.println("false: " + new Sol().divisorGame(3));
        System.out.println("false: " + new Sol().divisorGame(1));
        System.out.println("true: " + new Sol().divisorGame(4));
        System.out.println("false: " + new Sol().divisorGame(5));

    }
}

