import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Req
{

    public int getAct_time() {
        return act_time;
    }

    public int getCur_cost() {
        return cur_cost;
    }

    private int act_time;
    private int cur_cost;

    Req()
    {
        this.act_time = 0;
        this.cur_cost = 0;
    }
    public void time_sum(int num)
    {
        this.act_time += num;
    }
    public void cost_sum(int num)
    {
        this.cur_cost += num;
    }
}

class Order
{
    private int cost;

    public int getCost() {
        return cost;
    }

    public int getTime_start() {
        return time_start;
    }

    public int getTime_end() {
        return time_end;
    }

    private int time_start;
    private int time_end;


    Order(String[] words)
    {
        this.cost = Integer.parseInt(words[2]);
        this.time_start = Integer.parseInt(words[0]);
        this.time_end = Integer.parseInt(words[1]);
    }
}

public class Solution {

    public static void check_act(int act, Req one, Order or)
    {
        switch (act) {
            case (1):
                one.cost_sum(or.getCost());
                break;
            case (2):
                one.time_sum(or.getTime_end() - or.getTime_start());
                break;
        }
    }


    public static void main(String[] args) {

        ArrayList<Order> sortedProductList = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String note = in.nextLine();
        for (int i = 0; i < num; i++)
        {
            if (in.hasNextLine()) {
                note = in.nextLine();
                String[] words = note.split(" ");
                sortedProductList.add(new Order(words));
            }
        }


        num = in.nextInt();
        note = in.nextLine();
        Req one;
        for (int i = 0; i < num; i++)
        {
            one = new Req();
            if (in.hasNextLine()) {
                note = in.nextLine();
                String[] words = note.split(" ");
                for (int j = 0; j < sortedProductList.size(); j++)
                {
                    if (Integer.parseInt(words[2]) == 1
                            && Integer.parseInt(words[1]) >= sortedProductList.get(j).getTime_start()
                            && Integer.parseInt(words[0]) <= sortedProductList.get(j).getTime_start())
                    {
                        check_act(Integer.parseInt(words[2]), one, sortedProductList.get(j));
                    }

                    if (Integer.parseInt(words[2]) == 2
                            && Integer.parseInt(words[0]) <= sortedProductList.get(j).getTime_end()
                            && Integer.parseInt(words[1]) >= sortedProductList.get(j).getTime_end())
                    {
                        check_act(Integer.parseInt(words[2]), one, sortedProductList.get(j));
                    }
                }
                if (Integer.parseInt(words[2]) == 1)
                    System.out.print(one.getCur_cost() + " ");
                else
                    System.out.print(one.getAct_time() + " ");
            }

        }

        in.close();



//        sumTime(sortedProductList);
    }
}
