import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public class Main2 {
    static ArrayList<TreeSet<Integer>> graph;
    static int[] visited;
    static StringBuilder str = new StringBuilder();
    static int [][]matrix;
    static int count = 0;

    public static void dfs(int current, int prew)
    {

        visited[current] = 1;
        for (int neig: graph.get(current))
        {
            if (visited[neig] == 0) {
                matrix[current][neig] = 1;
                matrix[neig][current] = -1;
                dfs(neig, current);
            }
            if (visited[neig] == 1 && matrix[current][neig] == 0)
            {
                System.out.print("YES\n");
                str.append(current).append(" ");
                count++;
                str.append(neig).append(" ");
                count++;
                while (neig != prew) {
                    for (int i = 1; i < matrix.length; i++)
                        if (matrix[neig][i] == 1) {
                            neig = i;
                            count++;
                            str.append(neig).append(" ");
                            break;
                        }
                }
                System.out.println(count);
                System.out.println(str);
                System.exit(0);
            }
        }
        matrix[current][prew] = 2;
        matrix[prew][current] = 2;
        visited[current] = 2;
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

        int n = Integer.parseInt(in.readLine());
        graph = new ArrayList<>();
        visited = new int[n + 1];
        for (int j = 0; j < n + 1; j++)
            graph.add(new TreeSet<>());
        int[] ab;
        for (int i = 0; i < n; i++) {
            ab = toArrayInt(in.readLine().trim().split(" "));
            for (int j = 0; j < n; j++) {
                if (ab[j] != 0) {
                    graph.get(i + 1).add(j + 1);
                    graph.get(j + 1).add(i + 1);
                }
            }
        }
        in.close();
        matrix = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++)
        {
            if (visited[i] == 0) {
                dfs(i, 0);
            }
        }
        System.out.print("NO");
    }
}