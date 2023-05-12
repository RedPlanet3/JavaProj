import java.util.HashSet;
import java.util.LinkedList;

public class Main {
    public void bfs(LinkedList <int[]> queue, int[][] mat)
    {
        int [][] moves = {{1,0},{-1,0},{0,1},{0,-1}};
        int[] cur;
        while (queue.size() > 0) {
            cur = queue.getFirst();
            queue.removeFirst();
            for (int[] m: moves)
            {
                if (cur[0] + m[0] > -1 && cur[0] + m[0] < mat.length &&
                        cur[1] + m[1] > -1 && cur[1] + m[1] < mat[0].length)
                {
                    if (mat[cur[0] + m[0]][cur[1] + m[1]] > mat[cur[0]][cur[1]] + 1)
                    {
                        mat[cur[0] + m[0]][cur[1] + m[1]] = mat[cur[0]][cur[1]] + 1;
                        queue.add(new int[]{cur[0] + m[0], cur[1] + m[1]});
                    }
                }
            }
        }
    }
    public int orangesRotting(int[][] mat) {
        LinkedList<int[]> queue = new LinkedList<>();
        for(int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[0].length; j++)
            {
                if (mat[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    mat[i][j] = 0;
                }
                else if (mat[i][j] == 1) {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        bfs(queue, mat);
        int max = 0;
        for(int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[0].length; j++)
            {
                if (mat[i][j] == Integer.MAX_VALUE)
                    return -1;
                max = Math.max(max, mat[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Main ds = new Main();
        ds.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});
    }


}
