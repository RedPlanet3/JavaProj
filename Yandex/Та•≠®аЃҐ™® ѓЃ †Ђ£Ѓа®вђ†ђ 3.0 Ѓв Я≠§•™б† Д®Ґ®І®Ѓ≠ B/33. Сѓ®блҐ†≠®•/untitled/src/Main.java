import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    static ArrayList<TreeSet<Integer>> graph;
    static int[] visited;
    static TreeSet<Integer> comp;
    static HashMap<Integer, HashSet<Integer>> away = new HashMap<>();

    public static void dfs(int current, int color)
    {
        comp.add(current);
        visited[current] = color;
        for (int neig: graph.get(current))
        {
            if (visited[neig] == 0) {
                if (!away.containsKey(neig))
                    away.put(neig, new HashSet<>());
                away.get(neig).add(current);
                dfs(neig, color * -1);
            }
            if (visited[neig] == color)
            {
                System.out.println("NO");
                System.exit(1);
            }
        }
    }
    public static int[] toArrayInt(String[] str)
    {
        int []arr = new int[str.length];
        for (int i = 0; i < str.length; i++)
            arr[i] = Integer.parseInt(str[i]);
        return arr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));

        int []nm = toArrayInt(in.readLine().trim().split(" "));
        if (nm[0] == 1 || nm[1] == 0) {
            System.out.println("NO");
            System.exit(0);
        }
        graph = new ArrayList<>();
        comp = new TreeSet<>();
        visited = new int[nm[0] + 1];
        for (int j = 0; j < nm[0] + 1; j++)
            graph.add(new TreeSet<>());
        int[] ab;
        for (int i = 0; i < nm[1]; i++) {
            ab = toArrayInt(in.readLine().trim().split(" "));
                graph.get(ab[0]).add(ab[1]);
                graph.get(ab[1]).add(ab[0]);
        }
        in.close();
        for (int i = 1; i < nm[0] + 1; i++)
        {
            if (visited[i] == 0) {
                away.clear();
                dfs(i, 1);
            }
        }
        System.out.println("YES");
    }
}