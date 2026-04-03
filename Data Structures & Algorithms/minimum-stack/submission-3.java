class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    public MinStack() {
        stack=new ArrayDeque<>();
        minStack=new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val<=minStack.peek())
            minStack.push(val);
        
    }
    
    public void pop() {
        if(stack.peek().intValue()==minStack.peek().intValue())
            minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        System.out.println("stack: "+stack+" min stack: "+minStack);
        return minStack.peek();
    }
}
