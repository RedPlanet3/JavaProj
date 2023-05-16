import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static int sddf(LinkedList<int[]> qu, int [][]visit, int [][]move, int [][]arr)
    {
        int sum = 0;
        int[] tmp = new int[3];
        while (qu.size() > 0)
        {
            tmp= qu.getFirst();
            qu.removeFirst();
            visit[tmp[0]][tmp[1]] = 1;
            for (int [] step: move)
            {
                if (arr[tmp[0] + step[0]][tmp[1] + step[1]] != 0 && (visit[tmp[0] + step[0]][tmp[1] + step[1]] == 0)) {
                    if (sum == 0)
                        arr[tmp[0] + step[0]][tmp[1] + step[1]] = arr[tmp[0] + step[0]][tmp[1] + step[1]] + tmp[2] + sum;
                    else
                        arr[tmp[0] + step[0]][tmp[1] + step[1]] = arr[tmp[0] + step[0]][tmp[1] + step[1]] + sum;
                    sum = 0;
                    if (visit[tmp[0] + step[0]][tmp[1] + step[1]] == 0) qu.add(new int[]{tmp[0] + step[0], tmp[1] + step[1], arr[tmp[0] + step[0]][tmp[1] + step[1]]});
                    sum = sddf(qu, visit, move, arr);
                }
            }
        }
        return sum == 0 ? tmp[2]: sum;
    }
    public static int findMaxFish(int[][] grid) {
        int [][]arr = new int[grid.length + 2][grid[0].length + 2];
        int [][]visit = new int[grid.length + 2][grid[0].length + 2];
        LinkedList<int[]> qu = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++)
            {
                arr[i + 1][j + 1] = grid[i][j];
            }
        }

        int [][]move = new int[][]{{1,0}, {0, 1}, {-1,0}, {0, -1}};
        for (int i = 1; i < grid.length + 1; i++)
        {
            for (int j = 1; j < grid[0].length + 1; j++)
            {
                if (arr[i][j] != 0 && visit[i][j] == 0) {
                    qu.add(new int[]{i, j, arr[i][j]});
                    sddf(qu, visit, move, arr);
                }
            }

        }
        int max = arr[1][1];
        for (int i = 1; i < grid.length + 2; i++)
        {
            for (int j = 1; j < grid[0].length + 2; j++)
                max = Math.max(arr[i][j], max);
        }
        return max;

    }


    public static void main(String[] args) {
        System.out.println("7: " + findMaxFish(new int[][]{{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}}));
        System.out.println("17: " + findMaxFish(new int[][]{{6,1,10}}));
        System.out.println("23: " + findMaxFish(new int[][]{{10,5}, {8,0}}));
        System.out.println("22: " + findMaxFish(new int[][]{{8,6}, {2,6}}));

    }
}