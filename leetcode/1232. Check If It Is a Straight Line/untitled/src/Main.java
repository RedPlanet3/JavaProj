public class Main {
    public static boolean checkStraightLine(int[][] coor) {
        if (coor.length > 2) {
            int x1 = coor[0][0];
            int x2 = coor[1][0];
            int y1 = coor[0][1];
            int y2 = coor[1][1];
            for (int i = 2; i < coor.length; i++) {
                int x3 = coor[i][0];
                int y3 = coor[i][1];;
                if ((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1) != 0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkStraightLine(new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}));
        System.out.println(checkStraightLine(new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}}));
        System.out.println(checkStraightLine(new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}));
    }
}