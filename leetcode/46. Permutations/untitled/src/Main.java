import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public void req(List<List<Integer>> list, List<Integer> curList, List<Integer> first, int ind)
    {
        List<Integer> tmp = new LinkedList<>(curList);
        List<Integer> tmpFirst = new LinkedList<>(first);
        tmp.add(tmpFirst.get(ind));
        tmpFirst.remove(ind);

        if (tmpFirst.size() > 0)
        {
            for (int i = 0; i < tmpFirst.size(); i++)
                req(list, tmp, tmpFirst, i);
        }
        else
            list.add(tmp);

    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> fullList = new LinkedList<>();
        for (int m : nums)
            fullList.add(m);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            req(list, new LinkedList<>(), fullList, i);
        return list;
    }

    public static void main(String[] args) {
        Main ds = new Main();
        System.out.println("[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1 ,2],[3,2,1]]\n" + ds.permute(new int[]{1,2,3}));
        System.out.println("[[0,1],[1,0]]\n" + ds.permute(new int[]{0,1}));
        System.out.println("[[1]]\n" + ds.permute(new int[]{1}));

    }
}