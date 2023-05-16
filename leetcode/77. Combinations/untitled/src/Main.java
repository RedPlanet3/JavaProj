import java.util.ArrayList;
import java.util.List;

public class Main {
    public void req(int[] arr, List<List<Integer>> list, int k, List<Integer> curList, int ind)
    {
        List<Integer> tmp = new ArrayList<>(curList);
        tmp.add(arr[ind]);
        if (tmp.size() < k)
        {
            for (int i = ind + 1; i < arr.length; i++)
                req(arr, list, k, tmp, i);
        }
        else
            list.add(tmp);

    }
    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i + 1;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n - k + 1; i++)
            req(arr, list, k, new ArrayList<>(), i);
        return list;
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("12,13,14,23,24,34\n" + ds.combine(4,2));
        System.out.println("123,124,125,134,135,145,234,235,245,345\n" + ds.combine(5,3));
        System.out.println("1\n" + ds.combine(1,1));
    }
}