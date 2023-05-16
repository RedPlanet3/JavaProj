import java.util.Arrays;
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
    public int[][] updateMatrix(int[][] mat) {
        LinkedList <int[]> queue = new LinkedList<>();
        for(int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[0].length; j++)
            {
                if (mat[i][j] == 0)
                    queue.add(new int[]{i,j});
                else mat[i][j] = Integer.MAX_VALUE;
            }
        }
        bfs(queue,mat);
        return mat;
    }

    public static void main(String[] args) {
        Main ds = new Main();
//        System.out.println("[[0,0,0],[0,1,0],[0,0,0]]\n" +
//                Arrays.toString(ds.updateMatrix(new int[][]{{0,0,0},{0,1,0},{0,0,0}})));
        System.out.println("[[0,0,0],[0,1,0],[0,0,0]]\n" +
                Arrays.toString(ds.updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}})));
    }
}
