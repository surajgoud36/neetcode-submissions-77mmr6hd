class MyQueue {
    Deque<Integer> pushStack;
    Deque<Integer> popStack;
    public MyQueue() {
        pushStack=new ArrayDeque<>();
        popStack=new ArrayDeque<>();
    }
    
    public void push(int x) {   
        pushStack.push(x);
    }
    
    public int pop() {
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty())
                popStack.push(pushStack.pop());
            
        }
        return popStack.pop();
    }
    
    public int peek() {
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty())
                popStack.push(pushStack.pop());
            
        }
        return popStack.peek();
    }
    
    public boolean empty() {
        if(pushStack.isEmpty() && popStack.isEmpty())
            return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */