import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sc][sr];
        if (startColor == color)
            return image;
        image[sc][sr] = color;
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
//                    if (tmp[1] == sc && tmp[0] == sr)
                        line.add(new Integer[]{tmp[0] + step[0], tmp[1] + step[1]});
                }
            }
        }
        return image;
    }

//    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//        int startColor = image[sr][sc];
//        if (startColor == color)
//            return image;
//        image[sr][sc] = color;
//        LinkedList<Integer[]> line = new LinkedList<>();
//        int [][]move = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};
//        line.add(new Integer[]{sr, sc});
//        Integer []tmp;
//        while (line.size() > 0) {
//            tmp = line.getFirst();
//            line.removeFirst();
//            for (int[] step : move) {
//                if (tmp[0] + step[0] > -1 && tmp[0] + step[0] < image.length &&
//                        tmp[1] + step[1] > -1 && tmp[1] + step[1] < image[0].length &&
//                        image[tmp[0] + step[0]][tmp[1] + step[1]] == startColor) {
//                    image[tmp[0] + step[0]][tmp[1] + step[1]] = color;
//                    if (tmp[0] == sr && tmp[1] == sc) line.add(new Integer[]{tmp[0] + step[0], tmp[1] + step[1]});
//                }
//            }
//        }
//        return image;
//    }

public void printArr(int [][]arr)
{
    for(int []tmp: arr)
        System.out.print(Arrays.toString(tmp));
    System.out.println("\n");
}
    public static void main(String[] args) {
        Main ds = new Main();
//        System.out.println("[2, 2, 2][2, 2, 0][2, 0, 1]");
//        ds.printArr(ds.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}}, 1,1,2));
//        System.out.println("[2, 2, 2][2, 2, 0][2, 0, 1]");
//        ds.printArr(ds.floodFill(new int[][]{{0,0,0},{0,0,0},{1,0,1}}, 1,1,2));
//        System.out.println("[2, 2, 2][2, 2, 2]");
//        ds.printArr(ds.floodFill(new int[][]{{0,0,0},{0,0,0}}, 1,0,2));
        System.out.println("[2, 2, 2][2, 1, 2]");
        ds.printArr(ds.floodFill(new int[][]{{0,0,0},{0,1,0}}, 0,0,2));
    }
}