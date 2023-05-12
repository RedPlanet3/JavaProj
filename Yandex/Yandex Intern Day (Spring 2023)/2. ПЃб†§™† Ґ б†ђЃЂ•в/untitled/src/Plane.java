import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Plane {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Character>[] plane = new ArrayList[30];

        int count = Integer.parseInt(reader.readLine());
        int time = 0;
        Queue<String[]> queue = new LinkedList<>();
        for (int i = 0; i < count; i++)
            queue.add(reader.readLine().trim().split(" "));

        String[][] step = new String[30][2];
        while (true)
        {
            if (step[0] == null)
                step[0] = queue.poll();

        }

//        reader.close();
//        writer.close();
    }

}
