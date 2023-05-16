//
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.TreeSet;
//
//public class s1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        TreeSet<Integer> diogoSet = new TreeSet<>();
//        int p;
//        for (int i = 0; i < n; i++)
//            diogoSet.add(in.nextInt());
//        int k = in.nextInt();
//        for(int i = 0; i < k; i++)
//        {
//            p = in.nextInt();
//            int j = 0;
//            for (Integer num: diogoSet)
//            {
//                if (p <= num) {
//                    break;
//                }
//                j++;
//            }
//            System.out.println(j);
//        }
//    }
//}