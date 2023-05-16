import com.sun.deploy.security.SelectableSecurityManager;
import javafx.collections.transformation.SortedList;

import java.util.*;
import java.util.stream.Collectors;

class Cur_Car
{
    private int start_act;

    public int getStart_act() {
        return start_act;
    }

    public int getAct_time() {
        return act_time;
    }

    public String getCur_act() {
        return cur_act;
    }

    public int getName() {
        return name;
    }

    private int act_time;
    private String cur_act;
    private int name;

    Cur_Car(int name)
    {
        this.name = name;
        this.start_act = 0;
        this.act_time = 0;
        this.cur_act = "";
    }

    public void close_act(int time)
    {
        this.act_time += time - start_act;
    }
    public void start_act(int time)
    {
        this.start_act = time;
    }
}

class Car
{
    public int getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public String getAct() {
        return act;
    }

    private int name;
    private int time;
    private String act;


    Car(String[] words)
    {
        this.name = Integer.parseInt(words[3]);
        this.act = words[4];
//        int f = Integer.parseInt(words[2]);

        this.time = Integer.parseInt(words[2]) +
                Integer.parseInt(words[1]) * 60 +
                Integer.parseInt(words[0]) * 24 * 60;
    }
}

public class Solution {

    public static void check_act(int time, String act, Cur_Car one)
    {
        switch (act) {
            case ("A"):
                one.start_act(time);
                break;
            case ("B"):
                break;
            case ("C"):
                one.close_act(time);
                break;
            case ("S"):
                one.close_act(time);
                break;
        }
    }

    public static void sumTime(List<Car> sortedProductList)
    {
        Cur_Car one = null;
        int tmpName = 0;
        for (int i = 0; i < sortedProductList.size(); i++)
        {
            if (tmpName == 0) {
                tmpName = sortedProductList.get(i).getName();
                one = new Cur_Car(tmpName);
            }
            else {
                if (tmpName != sortedProductList.get(i).getName()) {
                    System.out.print(one.getAct_time() + " ");
                    tmpName = sortedProductList.get(i).getName();
                    one = new Cur_Car(tmpName);
                }
            }
            check_act(sortedProductList.get(i).getTime(), sortedProductList.get(i).getAct(), one);
        }
        if (one != null)
            System.out.print(one.getAct_time());
    }

    public static void main(String[] args) {

        ArrayList<Car> logs = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String note = in.nextLine();
        for (int i = 0; i < num; i++)
        {
            if (in.hasNextLine()) {
                note = in.nextLine();
                String[] words = note.split(" ");
                logs.add(new Car(words));
            }
        }
        in.close();

        List<Car> sortedProductList = logs.stream().sorted(
                Comparator.comparing(Car::getName)
                        .thenComparing(Car::getTime)
        ).collect(Collectors.toList());

        sumTime(sortedProductList);
    }
}
