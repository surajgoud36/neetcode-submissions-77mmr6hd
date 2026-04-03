record Pair(int price,int span){}
class StockSpanner {
    Deque<Pair> stack;
    public StockSpanner() {
        stack=new ArrayDeque<>();
    }
    
    public int next(int price) {
        int count=1;
        while(!stack.isEmpty() && stack.peek().price()<=price){
            count+=stack.peek().span();
            stack.pop();
        }
        stack.push(new Pair(price,count));
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */