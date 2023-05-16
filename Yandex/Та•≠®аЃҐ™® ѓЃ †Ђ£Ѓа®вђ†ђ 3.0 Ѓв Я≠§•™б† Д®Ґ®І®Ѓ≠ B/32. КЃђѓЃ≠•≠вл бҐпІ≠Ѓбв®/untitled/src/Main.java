import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class Main {
    static ArrayList<TreeSet<Integer>> graph;
//    static LinkedList<Integer> topological = new LinkedList<>();
    static int[] visited;
    static ArrayList<LinkedList<Integer>> comp;
    static TreeSet<Integer> secondRoom = new TreeSet<>();

    public static void dfs(int current, int ch)
    {
        visited[current] = 1;
        for (int neig: graph.get(current))
        {
            if (visited[neig] == 0) {
                dfs(neig, ch);
            }
        }
        visited[current] = 2;
        comp.get(ch).add(current);
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
        comp = new ArrayList<>();
        visited = new int[nm[0] + 1];
        for (int j = 0; j < nm[0] + 1; j++)
            graph.add(new TreeSet<>());
        int[] ab;
        for (int i = 0; i < nm[1]; i++) {
            ab = toArrayInt(in.readLine().trim().split(" "));
            if (!graph.get(ab[0]).contains(ab[1]))
                graph.get(ab[0]).add(ab[1]);
            secondRoom.add(ab[1]);
//            if (!graph.get(ab[1]).contains(ab[0]))
//                graph.get(ab[1]).add(ab[0]);
        }
        in.close();
        int ch = -1;
        for (int i = 1; i < nm[0] + 1; i++)
        {
            if (visited[i] == 0) {
                ch++;
                comp.add(new TreeSet<>());
                dfs(i, ch);
            }
        }
        boolean good = true;
        for (int num:visited) {
            if (num == 0)
                continue;
            if (num != 2) {
                System.out.println(-1);
                good = false;
                break;
            }
        }

        if (good) {
            StringBuilder str = new StringBuilder();
            for (LinkedList<Integer> curComp : comp) {
                for (int num : curComp) {
                    str.insert(0, " ").insert(0, num);
                    secondRoom.remove(num);
                }
            }
            if (secondRoom.size() > 0)
                System.out.println(-1);
            else
                System.out.print(str);
        }
    }
}