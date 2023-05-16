public class Main {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int [] client: accounts)
        {
            int tmp = 0;
            for (int num: client)
                tmp += num;
            max = Math.max(max, tmp);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}