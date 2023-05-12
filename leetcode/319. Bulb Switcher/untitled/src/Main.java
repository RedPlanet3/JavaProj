public class Main {

    public static int countOfDelim(int num)
    {
        int count = 0;
        int k = 1;
        int j = 1;
        while (k < num)
        {
            count++;
            k = (int)Math.pow(j,2);
            j++;
        }
        return count;
    }
//    public static int bulbSwitch(int n) {
//        int count = 0;
//        int k = 0;
//        int j = 1;
//        while (k < n + 1)
//        {
//            count++;
//            k = (int)Math.pow(j++,2);
//        }
//        return count - 1;
//    }

    public static int bulbSwitch(int n) {
        return (int)Math.pow(n,0.5);
    }

    public static void main(String[] args) {
        System.out.println("0: " + bulbSwitch(0));
        System.out.println("1: " + bulbSwitch(1));
        System.out.println("1: " + bulbSwitch(2));
        System.out.println("1: " + bulbSwitch(3));
        System.out.println("2: " + bulbSwitch(4));
        System.out.println("2: " + bulbSwitch(5));
        System.out.println("2: " + bulbSwitch(6));
        System.out.println("2: " + bulbSwitch(7));
        System.out.println("2: " + bulbSwitch(8));
        System.out.println("3: " + bulbSwitch(9));
        System.out.println("3: " + bulbSwitch(10));
    }
}