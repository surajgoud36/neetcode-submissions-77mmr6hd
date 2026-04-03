class MinStack {
    ArrayDeque<Map.Entry<Integer,Integer>> stack;
    
    public MinStack() {
        stack=new ArrayDeque<>();
        
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new AbstractMap.SimpleEntry<>(val,val));
            
        }
        else{
            int prev=stack.peek().getValue();
            stack.push(new AbstractMap.SimpleEntry<>(val,Math.min(val,prev)));
        }
            
      
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().getKey();
    }
    
    public int getMin() {
        return stack.peek().getValue();
    }
}
