public class Main {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int sum = 0;
        for (int i = 1; i < prices.length; i++)
        {
            if (prices[i] < min)
                min = prices[i];
            else if (prices[i] - min > sum)
                sum = prices[i] - min;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(new Main().maxProfit(new int []{7,1,5,3,6,4}));
        System.out.println(new Main().maxProfit(new int []{7,6,4,3,1}));
        System.out.println(new Main().maxProfit(new int []{7,1,5,3,6,4,0,4}));
        System.out.println(new Main().maxProfit(new int []{7}));
        System.out.println(new Main().maxProfit(new int []{0}));
        System.out.println(new Main().maxProfit(new int []{0,0}));
    }
}

//int min = 1;
//int sum = -5;
//7,  1,  5, 3, 6, 4, 1
//-1 -1   1  -1 1
