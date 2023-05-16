import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class Main {
    static ArrayList<TreeSet<Integer>> graph;
    static int[] visited;
    static TreeSet<Integer> comp;

    public static void dfs(int current)
    {
        comp.add(current);
        visited[current] = 1;
        for (int neig: graph.get(current))
        {
            if (visited[neig] == 0)
                dfs(neig);
        }
    }
    public static int[] toArrayInt(String s[])
    {
        int []arr = new int[s.length];
        for (int i = 0; i < s.length; i++)
            arr[i] = Integer.parseInt(s[i]);
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));

        int []nm = toArrayInt(in.readLine().trim().split(" "));
        graph = new ArrayList<>();
        comp = new TreeSet<>();
        visited = new int[nm[0] + 1];
        for (int j = 0; j < nm[0] + 1; j++)
            graph.add(new TreeSet<>());
        int[] ab;
        for (int i = 0; i < nm[1]; i++) {
            ab = toArrayInt(in.readLine().trim().split(" "));
            if (!graph.get(ab[0]).contains(ab[1]))
                graph.get(ab[0]).add(ab[1]);
            if (!graph.get(ab[1]).contains(ab[0]))
                graph.get(ab[1]).add(ab[0]);
        }
        in.close();
        dfs(1);
        System.out.println(comp.size());
        StringBuilder str = new StringBuilder();
        for (int num: comp)
            str.append(num).append(" ");
        System.out.println(str);
    }
}