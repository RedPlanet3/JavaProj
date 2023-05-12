import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answ = new ArrayList<>();
        answ.add(new ArrayList<>());
        answ.get(0).add(1);
        if (numRows > 1) {
            answ.add(new ArrayList<>());
            answ.get(1).add(1);
            answ.get(1).add(1);
        }

        for (int i = 2; i < numRows; i++)
        {
            answ.add(new ArrayList<>());
            answ.get(i).add(1);
            for (int j = 1; j < i; j++)
                answ.get(i).add(answ.get(i - 1).get(j - 1) + answ.get(i - 1).get(j));
            answ.get(i).add(1);
        }
        return answ;
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> answ = new ArrayList<>();
        answ.add(new ArrayList<>());
        answ.get(0).add(1);
        if (rowIndex > 0) {
            answ.add(new ArrayList<>());
            answ.get(1).add(1);
            answ.get(1).add(1);
        }

        for (int i = 2; i < rowIndex + 1; i++)
        {
            answ.add(new ArrayList<>());
            answ.get(i).add(1);
            for (int j = 1; j < i; j++)
                answ.get(i).add(answ.get(i - 1).get(j - 1) + answ.get(i - 1).get(j));
            answ.get(i).add(1);
        }
        return answ.get(rowIndex);
    }

    public static void main(String[] args) {
        System.out.println(new Main().getRow(0));
        System.out.println(new Main().getRow(1));
        System.out.println(new Main().getRow(2));
        System.out.println(new Main().getRow(3));
        System.out.println(new Main().getRow(4));
        System.out.println(new Main().getRow(5));
        System.out.println(new Main().getRow(33));

    }
}