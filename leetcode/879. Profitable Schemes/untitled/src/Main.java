//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicInteger;
//
//public class Main {
//    final int MOD = 1000000000 + 7;
//    int count;
//
//    public void scheme(int n, int minProfit, int[] group, int[] profit, int curInd)
//    {
//        n = n - group[curInd];
//        minProfit = minProfit - profit[curInd];
//        if (n < 0) return;
////        if (minProfit <= 0) count.set((count.get() + 1) % MOD);
//        if (minProfit <= 0) count = (count + 1) % MOD;
//        for (int i = curInd + 1; i < profit.length; i++)
//            scheme(n, minProfit, group, profit, i);
//    }
//    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
////        AtomicInteger count = new AtomicInteger(0);
//        count = 0;
//        if (minProfit == 0) return profit.length;
//        for (int i = 0; i < profit.length; i++)
//            scheme(n, minProfit, group, profit, i);
//        return count;
//    }
//
//    public static void main(String[] args) {
//        Main ds = new Main();
//        System.out.println("2: " + ds.profitableSchemes(5, 3, new int[]{2,2}, new int[]{2,3}));
//        System.out.println("7: " + ds.profitableSchemes(10, 5, new int[]{2,3,5}, new int[]{6,7,8}));
//        System.out.println("2: " + ds.profitableSchemes(64, 0, new int[]{80, 40}, new int[]{88, 88}));
//    }
//}