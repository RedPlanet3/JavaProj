public class Main {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][1] = 1;
        for (int i = 1; i < m + 1; i++)
        {
            for (int j = 1; j < n + 1; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("28: " + ds.uniquePaths(3,7));
        System.out.println("3: " + ds.uniquePaths(3,2));
        System.out.println("1: " + ds.uniquePaths(1,1));
        System.out.println("15: " + ds.uniquePaths(3,5));
        System.out.println("1: " + ds.uniquePaths(1,5));
    }
}