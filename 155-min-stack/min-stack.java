import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;     // main stack
    private Stack<Integer> minStack;  // stack to track minimums

    // Constructor
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    // Push operation
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // Pop operation
    public void pop() {
        int removed = stack.pop();
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    // Top operation
    public int top() {
        return stack.peek();
    }

    // Get minimum operation
    public int getMin() {
        return minStack.peek();
    }
}
