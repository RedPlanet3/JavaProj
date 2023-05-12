import java.util.ArrayList;

public class Main {
    static boolean find = false;

    public static void dfs(int visited[], int start, ArrayList<Integer>[] graph, int destination)
    {
        visited[start] = -1;
        for(int num: graph[start])
        {
            if (num == destination)
                find = true;
            if (visited[num] == 0)
                dfs(visited, num, graph, destination);
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        find = false;
        ArrayList<Integer>[] graph = new ArrayList[n];
        int visited[] = new int[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int ab[]: edges) {
            graph[ab[0]].add(ab[1]);
            graph[ab[1]].add(ab[0]);
        }
        if (source == destination)
            return true;
        dfs(visited, source, graph, destination);
        return find;
    }
    public static void main(String[] args) {
        System.out.println("true:" +  new Main().validPath(10,new int[][]{{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}}, 5, 9));
    }
}