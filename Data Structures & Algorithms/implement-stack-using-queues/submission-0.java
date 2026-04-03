class MyStack {
    Deque<Integer> st1;
    Deque<Integer> st2;
    public MyStack() {
        st1=new ArrayDeque<>();
        st2=new ArrayDeque<>();
    }
    
    public void push(int x) {
        if(st1.isEmpty() && st2.isEmpty())
            st1.add(x);
        else if(st1.isEmpty())
            st2.add(x);
        else
            st1.add(x);
    }
    
    public int pop() {
        if(!st1.isEmpty()){
            while(st1.size()!=1){
                st2.add(st1.removeFirst());
            }
            return st1.removeFirst();
        }
        else{
             while(st2.size()!=1){
                st1.add(st2.removeFirst());
            }
            return st2.removeFirst();
        }
    }
    
    public int top() {
         if(!st1.isEmpty()){
            while(st1.size()!=1){
                st2.add(st1.removeFirst());
            }
            int ele=st1.peekFirst();
            st2.add(st1.removeFirst());
            return ele;
        }
        else{
             while(st2.size()!=1){
                st1.add(st2.removeFirst());
            }
            int ele=st2.peekFirst();
            st1.add(st2.removeFirst());
            return ele;
        }
    }
    
    public boolean empty() {
        if(st1.isEmpty() && st2.isEmpty())
            return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */