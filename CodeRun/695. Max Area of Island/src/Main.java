import java.util.LinkedList;

public class Main {

    public int isIsland(int []ij, int[][] grid)
    {
        int count = 1;
        boolean yes = true;
        int [][]moves = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        LinkedList<int[]> island = new LinkedList<>();
        island.add(ij);
        grid[ij[0]][ij[1]] = 2;
        int []cur;
        while (island.size() > 0)
        {
            cur = island.getFirst();
            island.removeFirst();
            for (int [] m: moves)
            {
                if (cur[0] + m[0] < grid.length && cur[0] + m[0] > -1
                        && cur[1] + m[1] < grid[0].length && cur[1] + m[1] > -1) {
                    int tmp = grid[cur[0] + m[0]][cur[1] + m[1]];
//                if (tmp == -1) yes = false;
                    if (tmp == 1) {
                        island.add(new int[]{cur[0] + m[0], cur[1] + m[1]});
                        count++;
                        grid[cur[0] + m[0]][cur[1] + m[1]] = 2;
                    }
                }
            }
        }
        if (yes) return count;
        return 0;
    }
    public void borders(int[][] grid)
    {
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) grid[0][i] = -1;
            else grid[0][i] = -2;
            if (grid[grid.length - 1][i] == 1) grid[grid.length - 1][i] = -1;
            else grid[grid.length - 1][i] = -2;
        }
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 1) grid[i][0] = -1;
            else grid[i][0] = -2;
            if (grid[i][grid[0].length - 1] == 1) grid[i][grid[0].length - 1] = -1;
            else grid[i][grid[0].length - 1] = -2;
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
//        borders(grid);
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == 1)
                    max = Math.max(isIsland(new int[]{i,j}, grid), max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("1: " + ds.maxAreaOfIsland(new int[][]{{1}}));
    }

}
