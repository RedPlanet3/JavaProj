import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<int[]> ways = new ArrayList<>();
        int capacity = 3;
        int[] tmp;
        ways.add(new int[]{Integer.MAX_VALUE, triangle.get(0).get(0),Integer.MAX_VALUE});
        for (int i = 1; i < triangle.size(); i++)
        {
            capacity++;
            tmp = new int[capacity];
            tmp[0] = Integer.MAX_VALUE;
            tmp[capacity - 1] = Integer.MAX_VALUE;
            for (int j = 1; j < capacity - 1; j++)
                tmp[j] = (Math.min(ways.get(i - 1)[j - 1], ways.get(i - 1)[j]) + triangle.get(i).get(j - 1));
            ways.add(tmp);
        }
        int min = ways.get(ways.size() - 1)[1];
        for (Integer num :ways.get(ways.size() - 1))
            min = Math.min(min, num);
        return min;
    }

    public static void main(String[] args) {
        Main ds = new Main();
        List<List<Integer>> tr = new ArrayList<>();
        tr.add(new ArrayList(Arrays.asList(2)));
        tr.add(new ArrayList(Arrays.asList(3,4)));
        tr.add(new ArrayList(Arrays.asList(6,5,7)));
        tr.add(new ArrayList(Arrays.asList(4,1,8,3)));
        System.out.println("11: " + ds.minimumTotal(tr));
        tr = new ArrayList<>();
        tr.add(new ArrayList<>(Arrays.asList(-10)));
        System.out.println("-10: " + ds.minimumTotal(tr));
    }
}