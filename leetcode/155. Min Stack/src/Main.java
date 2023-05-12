import java.util.ArrayList;
import java.util.Scanner;

class MinStack {
    ArrayList<Integer> myStack;
    ArrayList<Integer> minStack;

    public MinStack() {
        myStack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int val) {
        myStack.add(val);
        checkMin(val);
    }

    public void pop() {
        if (myStack.size() > 0) {
            if (top() == getMin())
                minStack.remove(minStack.size() - 1);
            myStack.remove(myStack.size() - 1);
            checkMin(top());
        }
    }

    public int top() {
        if (myStack.size() > 0)
            return myStack.get(myStack.size() - 1);
        return -1;
    }
    public void checkMin(int val)
    {
        if (val != -1 && (minStack.size() == 0 || getMin() > val))
            minStack.add(val);
    }

    public int getMin() {
        if (minStack.size() > 0)
            return minStack.get(minStack.size() - 1);
        return -1;
    }
}
public class Main {
    public static void main(String[] args) {
//         Your MinStack object will be instantiated and called as such:
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(" ");
        MinStack obj = new MinStack();
        for (int i = 0; i < str.length; i++)
        {
            obj.push(Integer.parseInt(str[i]));
        }
        System.out.println();
        System.out.println("obj.getMin():" + obj.getMin());
        obj.pop();
        System.out.println("obj.pop():" + obj.top());
        obj.pop();
        System.out.println("obj.pop():" + obj.top());
        obj.pop();
        System.out.println("obj.pop():" + obj.top());
        obj.pop();
        System.out.println("obj.pop():" + obj.top());
         int param_3 = obj.top();
         int param_4 = obj.getMin();
    }
}
