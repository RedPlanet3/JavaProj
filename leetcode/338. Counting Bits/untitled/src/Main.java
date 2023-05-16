import java.util.Arrays;

public class Main {
    public int[] countBits(int n) {
        int []ans = new int[n + 1];
        ans[0] = 0;
        if (n > 0) ans[1] = 1;
        int i = 2;
        int x = 1;
        int k;
        while(i < n + 1)
        {
            k = 0;
            while (i < n + 1 && k < (int)Math.pow(2,x))
            {
                ans[i] = ans[i - (int)Math.pow(2,x)] + 1;
                i++;
                k++;
            }
            x++;
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Main().countBits(0)));
        System.out.println(Arrays.toString(new Main().countBits(1)));
        System.out.println(Arrays.toString(new Main().countBits(2)));
        System.out.println(Arrays.toString(new Main().countBits(3)));
        System.out.println(Arrays.toString(new Main().countBits(4)));
        System.out.println(Arrays.toString(new Main().countBits(5)));
        System.out.println(Arrays.toString(new Main().countBits(6)));
        System.out.println(Arrays.toString(new Main().countBits(7)));
        System.out.println(Arrays.toString(new Main().countBits(8)));
        System.out.println(Arrays.toString(new Main().countBits(9)));
        System.out.println(Arrays.toString(new Main().countBits(10)));
        System.out.println(Arrays.toString(new Main().countBits(11)));
        System.out.println(Arrays.toString(new Main().countBits(12)));
        System.out.println(Arrays.toString(new Main().countBits(15)));
    }
}

//0   0       0
//1   1       1
//2   10      1
//3   11      2
//4   100     1
//5   101     2
//6   110     2
//7   111     3
//
//8   1000    1
//9   1001    2
//10  1010    2
//11  1011    3
//12  1100    2
//13  1101    3
//14  1110    3
//15  1111    4
//
//2 4 8 16
//1 2 3 4



