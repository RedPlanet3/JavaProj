import com.sun.tools.javac.Main;

import java.util.Arrays;

public class Solution {
    public boolean fullSol(int m, int [][] sol) {
        int k = (int)Math.pow(2,m);
        int j = 0;
        for(int i = 0; i <= Math.pow(2,m); i++)
        {
            if (k >= sol.length)
                return false;
            sol[k] = new int[]{sol[j][0] + (m % 2 == 0 ? 1 : 0),sol[j][1] + m % 2};
            k++;
            j++;
        }
        return true;
    }

    public int[] evenOddBit(int n) {
        int [][] sol = new int[n + 1][2];
        sol[0] = new int[]{0,0};
        sol[1] = new int[]{1,0};
        int m = 1;
        while(fullSol(m, sol))
            m++;
        return sol[n];
    }

    public static void main(String[] args) {
        System.out.println("2,0: " + Arrays.toString(new Solution().evenOddBit(17)));
        System.out.println("0,1: " + Arrays.toString(new Solution().evenOddBit(2)));
        System.out.println("1,0: " + Arrays.toString(new Solution().evenOddBit(1)));
        System.out.println("1,1:" + Arrays.toString(new Solution().evenOddBit(6)));
        System.out.println("2,1:" + Arrays.toString(new Solution().evenOddBit(7)));
    }
}


//0 2 4 8
//
//0 = 0       0,0
//1 = 1       1,0
//2 = 10      0,1
//3 = 11      1,1
//4 = 100     1,0
//5 = 101     2,0
//6 = 110     1,1
//7 = 111     2,1
//8 = 1000    0,1
//9 = 1001    1,1
//10= 1010    0,2
//11= 1011    1,2
//12= 1100    1,1
//13= 1101    2,1
//14= 1110    1,2
//15= 1111    2,2
//16

