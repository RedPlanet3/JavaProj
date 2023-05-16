import java.util.LinkedList;

public class Main {
    public char[][] floodFill(char[][] image, int sr, int sc, char color) {
        int startColor = image[sr][sc];
        if (startColor == color)
            return image;
        image[sr][sc] = color;
        LinkedList<Integer[]> line = new LinkedList<>();
        int [][]move = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        line.add(new Integer[]{sr, sc});
        Integer []tmp;
        while (line.size() > 0) {
            tmp = line.getFirst();
            line.removeFirst();
            for (int[] step : move) {
                if (tmp[0] + step[0] > -1 && tmp[0] + step[0] < image.length &&
                        tmp[1] + step[1] > -1 && tmp[1] + step[1] < image[0].length &&
                        image[tmp[0] + step[0]][tmp[1] + step[1]] == startColor) {
                    image[tmp[0] + step[0]][tmp[1] + step[1]] = color;
                    line.add(new Integer[]{tmp[0] + step[0], tmp[1] + step[1]});
                }
            }
        }
        return image;
    }
    public int numIslands(char[][] grid) {
        LinkedList<Integer[]> earth = new LinkedList<>();
//        int[][] image = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == '1')
                    earth.add(new Integer[]{i, j});
            }
        }
        Integer []tmp;
        int ch = 0;
        while (earth.size() > 0)
        {
            tmp = earth.getFirst();
            earth.removeFirst();
            if (grid[tmp[0]][tmp[1]] == '1') {
                ch++;
                floodFill(grid, tmp[0], tmp[1], '2');
            }
        }
        return ch;
    }
    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("1: " + ds.numIslands(
                new char[][]{
  {'1','1','1','1','0'},
  {'1','1','0','1','0'},
  {'1','1','0','0','0'},
  {'0','0','0','0','0'}}));
        System.out.println("3: " + ds.numIslands(
                new char[][]{
  {'1','1','0','0','0'},
  {'1','1','0','0','0'},
  {'0','0','1','0','0'},
  {'0','0','0','1','1'}}));


    }
}