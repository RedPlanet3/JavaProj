public class Main2 {
    final int MOD = 1000000000 + 7;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int [][]dp = new int[group.length + 1][n + 1];
        for (int i = 0; i < group.length; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 - group[i] >= 0)
                    dp[i + 1][j + 1] = Math.min(minProfit,Math.max(dp[i][j + 1], dp[i][j + 1 - group[i]] + profit[i]) % MOD);
            }
        }

        int i = group.length;
        int j = n;
        int count = 0;
        int cur;
        for (int k = n; k > -1; k--) {
            if (dp[group.length][k] >= minProfit) {
                cur = dp[i][j];
                while (j > -1 && dp[i][j - 1] == dp[i][j])
                while (true) {
                    if (dp[i][j] == 0)
                        break;
                    else if (dp[i - 1][j] < dp[i][j]) {
                        count++;
                        j -= i;
                    }
                    i--;
                }
            }
            else break;
        }

        return 0;
    }

    public static void main(String[] args) {
        Main2 ds = new Main2();
        System.out.println("2: " + ds.profitableSchemes(5, 3, new int[]{2,2}, new int[]{2,3}));
        System.out.println("7: " + ds.profitableSchemes(10, 5, new int[]{2,3,5}, new int[]{6,7,8}));
        System.out.println("2: " + ds.profitableSchemes(64, 0, new int[]{80, 40}, new int[]{88, 88}));
    }
}