import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public int isIsland(int []ij, int[][] grid)
    {
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
                int tmp = grid[cur[0] + m[0]][cur[1] + m[1]];
                if (tmp == -2) yes = false;
                else if (tmp == 0) {
                    island.add(new int[]{cur[0] + m[0], cur[1] + m[1]});
                    grid[cur[0] + m[0]][cur[1] + m[1]] = 2;
                }
            }
        }
        if (yes) return 1;
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

    public int closedIsland(int[][] grid) {
        int count = 0;
        borders(grid);
        for (int i = 1; i < grid.length - 1; i++)
        {
            for (int j = 1; j < grid[0].length - 1; j++)
            {
                if (grid[i][j] == 0)
                    count += isIsland(new int[]{i,j}, grid);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("2: " + ds.closedIsland(new int[][]
                {{1,1,1,1,1,1,1,0},
        {1,0,0,0,0,1,1,0},
        {1,0,1,0, 1,1,1,0},
        {1,0,0,0,0,1,0,1},
        {1,1,1,1,1,1,1,0}}));

        System.out.println("1: " + ds.closedIsland(new int[][]
                {{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}}));

        System.out.println("2: " + ds.closedIsland(new int[][]
                {{1,1,1,1,1,1,1}, 
               {1,0,0,0,0,0,1}, 
               {1,0,1,1,1,0, 1}, 
               {1,0,1,0,1,0,1}, 
               {1,0,1,1,1,0,1}, 
               {1,0,0,0,0,0,1} , 
               {1,1,1,1,1,1,1}}));
    }
}
