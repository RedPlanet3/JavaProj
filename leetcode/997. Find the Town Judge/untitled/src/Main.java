import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Main {
//    public int findCenter(int[][] edges) {
//        for(int num:edges[1])
//        {
//            if (num == edges[0][0] || num == edges[0][1])
//                return num;
//        }
//        return -1;
//    }
    public int findJudge(int n, int[][] trust) {
        HashSet<Integer> j = new HashSet<>();
        int ch = 0;
        for (int i = 1; i < n + 1; i++)
            j.add(i);
        for (int []num : trust)
            j.remove(num[0]);
        if (j.size() == 1) {
            for (int num : j) {
                for (int[] nums : trust)
                    if (nums[1] == num)
                        ch++;
                if (ch == n - 1)
                    return num;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(new Main().findJudge(4, new int[][]{{1,3},{1,4}, {2,3}}));
        System.out.println(new Main().findJudge(4, new int[][]{{1,2},{2,3}}));

        System.out.println(new Main().findJudge(4, new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}));
    }
}