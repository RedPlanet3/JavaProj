public class Main {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r * c)
            return mat;
        int[][] answ = new int[r][c];
        for(int i = 0; i < r * c; i++)
            answ[i / c][i % c] = mat[i / mat[0].length][i % mat[0].length];
        return answ;
    }
    public static void main(String[] args) {
        System.out.println("tg" + matrixReshape(new int[][]{{1,2},{3,4}}, 1,4));
    }
}