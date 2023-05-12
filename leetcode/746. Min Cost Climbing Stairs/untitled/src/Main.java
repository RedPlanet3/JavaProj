public class Main {
    public int minCostClimbingStairs(int[] cost) {
        int[]steps = new int[cost.length + 1];
        steps[1] = cost[0];
        for (int i = 2; i < steps.length; i++)
            steps[i] = Math.min(steps[i - 2] + cost[i - 1], steps[i - 1] + cost[i - 1]);
        return Math.min(steps[steps.length - 1], steps[steps.length - 2]);
    }
    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("15: " + ds.minCostClimbingStairs(new int[]{10, 15 ,20}));
        System.out.println("6: " + ds.minCostClimbingStairs(new int[]{1 ,100, 1 ,1, 1 , 100, 1 , 1 ,100, 1}));
        System.out.println("1: " + ds.minCostClimbingStairs(new int[]{1 ,100}));
    }
}