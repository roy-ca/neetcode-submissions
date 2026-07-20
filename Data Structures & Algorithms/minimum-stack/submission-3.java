class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int minElement;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
        minElement = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= minElement) {
            minElement = val;
            minStack.push(val);
        }
        stack.push(val);
    }
    
    public void pop() {
        int p = stack.pop();
        if(!minStack.isEmpty() && minStack.peek() == p) {
            minStack.pop();
            if(!minStack.isEmpty())
                minElement = minStack.peek();
            else 
             minElement = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minElement;
    }
}
