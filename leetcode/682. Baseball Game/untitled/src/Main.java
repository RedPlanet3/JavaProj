import java.util.Stack;

public class Main {
    public static int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String step : operations)
        {
            switch (step)
            {
                case "+":
                {
                    int second = stack.pop();
                    int first = stack.peek();
                    stack.push(second);
                    stack.push(second + first);
                    break;
                }
                case "D": {
                    stack.push(stack.peek() * 2);
                    break;
                }
                case "C":
                {
                    stack.pop();
                    break;
                }
                default:
                    stack.push(Integer.parseInt(step));
            }
        }
        int sum = 0;
        while (stack.size() > 0)
            sum += stack.pop();
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("30: " + calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println("27: " + calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
        System.out.println("0: " + calPoints(new String[]{"1","C"}));

    }
}