import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[in.nextInt()];
        for(int i = 0; i < arr.length; i++)
            arr[i] = in.nextInt();
        ArrayList<Integer> stack = new ArrayList<>();
        int sum = 0;
        int tmp = 0;
        for(int i = 0; i < arr.length; i++)
        {
            tmp = arr[i];
            while (true) {
                if ((stack.size() == 0) || (stack.get(stack.size() - 1) <= arr[i])) {
                    stack.add(arr[i]);
                    break;
                }
                else {
                    tmp = stack.get(0);
                    stack.remove(0);
                    if (stack.size() > 0) {
                        sum += tmp * stack.size();
                        for (int j = 0; j < stack.size(); j++)
                            stack.set(j, stack.get(j) - tmp);
                    }
                    
                    sum += tmp;
                }
            }
        }
        while (stack.size() > 1)
        {
            tmp = stack.get(0);
            stack.remove(0);
            if (stack.size() > 0) {
                sum += tmp * stack.size();
                for (int j = 0; j < stack.size(); j++)
                    stack.set(j, stack.get(j) - tmp);
            }
            sum += tmp;
        }


        System.out.println(sum);
    }
}