import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[])
    {
        BufferedReader inputDataBR = new BufferedReader(new InputStreamReader(System.in));

        List<Double> persents = new ArrayList<>(Arrays.asList(0.1,0.02));
        List<Integer> purchases = new ArrayList<>(Arrays.asList(100,300));

        double sum = 0;
        for (int i = 0; i < purchases.size(); i++) {
            sum = sum + purchases.get(i) * persents.get(i);
        }
        System.out.println(sum);
    }
}