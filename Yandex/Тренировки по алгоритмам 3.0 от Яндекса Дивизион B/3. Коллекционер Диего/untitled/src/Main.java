//
//
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.TreeSet;
//
//public class Main {
////    public static int binS(ArrayList<Integer> arr, int num, int left, int right)
////    {
////        if (num <= arr.get(left))
////            return 0;
////        if (num > arr.get(right - 1))
////            return arr.size();
////        int med = 0;
////        while (arr.size() > 1 && left != right) {
////
////            med = (right + left) / 2;
////            if (arr.get(med) == num)
////                return med;
////            if (med == left) {
////                if (num > arr.get(med))
////                    return med + 1;
////                return med;
////            }
////
////            else if (arr.get(med) > num)
////                right = med;
////            else
////                left = med + 1;
////        }
////        return arr.size() > 1? right: num <= arr.get(0)? 0 : arr.size();
////    }
////    public static int rbin(ArrayList<Integer> arr, int num, int left, int right)
////    {
////        int med;
////        if (num <= arr.get(left))
////            return 0;
////        if (num > arr.get(right))
////            return arr.size();
////        while (left < right)
////        {
////            med = (left + right) / 2;
////            if (arr.get(med) >= num)
////                right = med;
////            else
////                left = med + 1;
////        }
////        return left;
////    }
//
//     public static int frbin(TreeSet<Integer> arr, int num, int left, int right)
//    {
//        int med;
//        if (num <= arr.get(left))
//            return 0;
//        if (num > arr.get(right))
//            return arr.size();
//        while (left < right)
//        {
//            med = (left + right) / 2;
//            if (arr.get(med) >= num)
//                right = med;
//            else
//                left = med + 1;
//        }
//        return left;
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        TreeSet<Integer> diogoSet = new TreeSet<>();
//        int p;
//        for (int i = 0; i < n; i++)
//            diogoSet.add(in.nextInt());
////        ArrayList<Integer> arr = new ArrayList<>(diogoSet);
//
//        int k = in.nextInt();
//        for(int i = 0; i < k; i++) {
//            p = in.nextInt();
////            System.out.println("binS: " + binS(arr, p, 0, diogoSet.size()));
////            System.out.println(rbin(arr, p, 0, diogoSet.size() - 1));
//            System.out.println(diogoSet.headSet(p).size());
//
//
//        }
//    }
//}