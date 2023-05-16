import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] size = {in.nextInt(), in.nextInt()};
        int k = in.nextInt();
        int[][] pref = new int[size[0] + 1] [size[1] + 1];
        int[] xyxy;
        for (int x = 1; x < size[0] +1 ; x++) {
            for (int y = 1; y <  size[1] + 1; y++)
                pref[x][y] = (pref[x-1][y]) + (pref[x][y-1] - pref[x-1][y-1]) + in.nextInt();
        }
        for(int i = 0; i < k; i++) {
            xyxy = new int[]{in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()};
            int x1 = Math.min(xyxy[0], xyxy[2]);
            int x2 = Math.max(xyxy[0], xyxy[2]);
            int y1 = Math.min(xyxy[1], xyxy[3]);
            int y2 = Math.max(xyxy[1], xyxy[3]);
            System.out.println((pref[x2][y2] - pref[x1-1][y2]) - (pref[x2][y1 - 1] - pref[x1-1][y1 - 1]));
        }
    }
}