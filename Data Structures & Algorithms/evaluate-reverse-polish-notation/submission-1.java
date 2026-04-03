class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token:tokens){

            if(stack.isEmpty()|| check(token)){
                stack.push(Integer.parseInt(token));
                continue;
            }
            int second=stack.pop();
            int first=stack.pop();
            int res=0;
            switch(token){
                case "+":
                    res=first+second;
                    break;
                case "-":
                    res=first-second;
                    break;
                case "*":
                    res=first*second;
                    break;
                case "/":
                res=first/second;
                break;
            }
             stack.push(res);   
            
        }
        return stack.pop();
    }
    public boolean check(String token){
        if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/"))
            return false;
        return true;
    }
}
