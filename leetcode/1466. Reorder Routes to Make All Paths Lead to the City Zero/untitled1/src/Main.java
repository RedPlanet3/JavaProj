import java.util.TreeSet;

public class Main {
    static int ch = 0;
    public void dfs(TreeSet<Integer> visited, int town, TreeSet<Integer>[] graph)
    {
        visited.remove(town);
        for(int nearb: graph[town])
        {
            if (visited.contains(nearb))
                dfs(visited, nearb, graph);
        }
    }


    public void dfsNo(TreeSet<Integer> visited, int start, TreeSet<Integer>[] graphNotOr,  TreeSet<Integer>[] graph)
    {
        visited.remove(start);
        dfs(visited,start, graph);
        for(int nearb: visited)
        {
            ch++;
            dfs(visited, nearb, graph);
            dfsNo(visited, nearb, graphNotOr,  graph);
        }
    }
    public void fullReverseGraph(TreeSet<Integer>[] graph, int n, int[][] connections)
    {
        for(int[] road : connections)
            graph[road[1]].add(road[0]);
    }
    public void fullNotOrientGraph(TreeSet<Integer>[] graph, int n, int[][] connections)
    {
        for(int[] road : connections) {
            graph[road[1]].add(road[0]);
            graph[road[0]].add(road[1]);
        }
    }
    public int minReorder(int n, int[][] connections) {
        ch = 0;
        TreeSet<Integer>[] graph = new TreeSet[n];
        for(int i = 0; i < n; i++)
            graph[i] = new TreeSet<>();
        TreeSet<Integer>[] graphNotOr = new TreeSet[n];
        for(int i = 0; i < n; i++)
            graphNotOr[i] = new TreeSet<>();
        TreeSet<Integer> visited = new TreeSet<>();
        for(int i = 0; i < n; i++)
            visited.add(i);

        fullNotOrientGraph(graphNotOr, n, connections);
        fullReverseGraph(graph, n, connections);
        dfsNo(visited, 0, graphNotOr, graph);
        return ch + visited.size();
    }
    public static void main(String[] args) {
        Main ds = new Main();
//        System.out.println("3: " + ds.minReorder(6,new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}}));
        System.out.println("2: " + ds.minReorder(5,new int[][]{{1,0},{1,2},{3,2},{3,4}}));
//        System.out.println("0: " + ds.minReorder(3,new int[][]{{1,0},{2,0}}));
    }
}