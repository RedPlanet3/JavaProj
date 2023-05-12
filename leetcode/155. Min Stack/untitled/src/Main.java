import java.util.ArrayList;


class MinStack {
    ArrayList<Integer> myStack;
    ArrayList<Integer> minStack;
    int indSize = -1;

    public MinStack() {
        myStack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int val) {
        myStack.add(val);
        if (indSize > -1)
            minStack.add(Math.min(val,minStack.get(indSize)));
        else
            minStack.add(val);
        indSize++;
    }

    public void pop() {
        myStack.remove(indSize);
        minStack.remove(indSize);
        indSize--;
    }

    public int top() {
        if (myStack.size() > 0)
            return myStack.get(indSize);
        return -1;
    }

    public int getMin() {
        if (minStack.size() > 0)
            return minStack.get(indSize);
        return -1;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}