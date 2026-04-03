class FreqStack {
    Map<Integer,Integer> eleF;
    Map<Integer,Integer> ff;
    Deque<Integer> stack;
    Deque<Integer> stack2;
    public FreqStack() {
        eleF=new HashMap<>();
        ff=new HashMap<>();
        stack=new ArrayDeque<>();
        stack2=new ArrayDeque<>();
    }
    
    public void push(int val) {
        eleF.put(val,eleF.getOrDefault(val,0)+1);
        if(!ff.containsKey(eleF.get(val)))
            stack2.push(eleF.get(val));
        ff.put(eleF.get(val),ff.getOrDefault(eleF.get(val),0)+1);
        stack.push(val);
    }
    
    public int pop() {
        Deque<Integer> temp = new ArrayDeque<>();
        while(eleF.get(stack.peek())!=stack2.peek()){
            temp.push(stack.pop());
        }
        int ele=stack.pop();
        eleF.put(ele,eleF.get(ele)-1);
        if(eleF.get(ele)<=0)
            eleF.remove(ele);
        ff.put(stack2.peek(),ff.get(stack2.peek())-1);
        if(ff.get(stack2.peek())<=0){
            
            ff.remove(stack2.pop());
        }
        while(!temp.isEmpty()){
            stack.push(temp.pop());
        }
        return ele;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */