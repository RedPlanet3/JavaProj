import java.util.ArrayList;
import java.util.TreeSet;

public class Main {
    static int minWay = 2147483647;
    void dfs(int[] start, int finish, int []weigth, ArrayList<int[]>[] graph)
    {
        weigth[start[0]] = 1;
        for (int[] con: graph[start[0]])
        {
            if (weigth[con[0]] == 0 || con[1] < minWay) {
                minWay = Math.min(minWay, con[1]);
                dfs(con, finish, weigth, graph);
            }
        }
    }
    public void fullGrapf(ArrayList<int[]>[] graph, int[][] roads)
    {
        for (int []connect : roads)
        {
            graph[connect[0]].add(new int[]{connect[1], connect[2]});
            graph[connect[1]].add(new int[]{connect[0], connect[2]});
        }
    }
    public int minScore(int n, int[][] roads) {
        minWay  = 2147483647;
        ArrayList<int[]>[] graph = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++)
            graph[i] = new ArrayList<>();
        fullGrapf(graph, roads);
        int []weigth = new int[n + 1];

        dfs(new int[]{1, 0}, n, weigth, graph);
        return minWay;
    }
    

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("1885: " + ds.minScore(6,new int[][]{{4,5,7468},{6,2,7173},{6,3,8365},{2,3,7674},{5,6,7852},{1,2,8547},{ 2,4,1885},{2,5,5192},{1,3,4065},{1,4,7357}}));
        System.out.println("5: " + ds.minScore(4,new int[][]{{1,2,9},{2,3,6}, {2,4,5}, {1,4,7}}));
        System.out.println("2: " + ds.minScore(4,new int[][]{{1,2,2},{1,3,4}, {3,4,7}}));
    }
}