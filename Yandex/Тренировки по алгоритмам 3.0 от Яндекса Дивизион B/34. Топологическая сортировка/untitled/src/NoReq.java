
import java.io.BufferedReader;
        import java.io.FileReader;
        import java.io.IOException;
        import java.io.PrintWriter;
        import java.util.*;

public class NoReq {
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer> strAnsw = new ArrayList<>();
    static int[] visited;
    static StringBuilder compStr = new StringBuilder();
    static PrintWriter pw;
    static int chF = 0;

    public static void dfs(int current, int ch)
    {
        visited[current] = 1;
        for (int neig: graph[current])
        {
            if (visited[neig] == 2)
                continue;
            if (visited[neig] == -1) {
                dfs(neig, ch);
            }
            if (visited[neig] == 1)
            {
                pw.println(-1);
                pw.close();
                System.exit(0);
            }
        }
        visited[current] = 2;
        strAnsw.add(current);
        chF++;
    }

    public static void dfsNoReq(int current, int ch)
    {
        boolean isBreak = false;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(current);
        while (stack.size() > 0) {
            visited[current] = 1;
            isBreak = false;
            for (int neig : graph[current]) {
                if (visited[neig] == 2)
                    continue;
                if (visited[neig] == -1) {
                    current = neig;
                    stack.add(neig);
                    isBreak = true;
                    break;
                }
                if (visited[neig] == 1) {
                    pw.println(-1);
                    pw.close();
                    System.exit(0);
                }
            }
            if (isBreak)
                continue;
            visited[current] = 2;
            stack.removeLast();
            strAnsw.add(current);
            if (stack.size() > 0)
                current = stack.getLast();
            chF++;
        }
    }


    public static int fastParseInt(String str) {
        int res = 0;
        char ch;

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch >= '0' && ch <= '9')
                res = res * 10 + (ch - '0');
        }
        return res;
    }

    public static int[] toArrayInt(String []s)
    {
        int []arr = new int[s.length];
        for (int i = 0; i < s.length; i++)
            arr[i] = fastParseInt(s[i]);
        return arr;
    }
    public static void main(String[] args) throws IOException, InterruptedException {

//        long start = System.nanoTime();


        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        pw = new PrintWriter("output.txt");
        int []nm = toArrayInt(in.readLine().trim().split(" "));
        graph = new ArrayList[nm[0] + 1];
        visited = new int[nm[0] + 1];
        for (int j = 0; j < nm[0] + 1; j++)
            graph[j] = new ArrayList<>();
        int[] ab;
        for (int i = 0; i < nm[1]; i++) {
            ab = toArrayInt(in.readLine().trim().split(" "));
            graph[ab[0]].add(ab[1]);
            visited[ab[1]] = -1;
        }
        in.close();
        int ch = -1;
        for (int i = 1; i < nm[0] + 1; i++)
        {
            if (visited[i] == 0)
//                dfsNoReq(i, ch++);
                dfs(i, ch++);
        }
        if (ch == -1 || nm[0] > chF)
            pw.println(-1);
        else {
            for (int i = strAnsw.size() - 1; i > -1; i--)
                compStr.append(strAnsw.get(i)).append(" ");
            pw.println(compStr);
            }
        pw.close();

//        Thread.sleep(1000);
//        long finish = System.nanoTime();
//        long elapsed = finish - start;
//        System.out.println("Прошло времени, нс: " + elapsed / 1000000);
    }
}
