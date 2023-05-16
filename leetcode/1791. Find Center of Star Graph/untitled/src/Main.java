public class Main {
    public int findCenter(int[][] edges) {
        for(int num:edges[1])
        {
            if (num == edges[0][0] || num == edges[0][1])
                return num;
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}