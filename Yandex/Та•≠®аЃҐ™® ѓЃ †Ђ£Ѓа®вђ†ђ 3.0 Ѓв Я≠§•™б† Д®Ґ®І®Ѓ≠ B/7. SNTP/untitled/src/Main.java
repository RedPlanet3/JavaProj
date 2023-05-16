import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] time = new int[3];

        for(int i = 0; i < 3; i++)
        {
            String[] str = in.nextLine().trim().split(":");
            time[i] = Integer.parseInt(str[0]) * 60 * 60 +
                    Integer.parseInt(str[1]) * 60 +
                    Integer.parseInt(str[2]);
        }
        time[2] = time[2] < time[0] ? time[2] + 24 * 3600 : time[2];
        int diff = Math.round((time[2] - time[0]) / 2f);
        time[1] += diff;
        System.out.printf("%02d:", time[1] / 3600 % 24);
        System.out.printf("%02d:", (time[1]  % 3600) / 60);
        System.out.printf("%02d", (time[1]  % 3600) % 60);
    }
}