class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        Set<String> op=new HashSet<>(Arrays.asList("+","-","/","*"));
        for(String s:tokens){
            if(!op.contains(s)){
                stack.push(Integer.valueOf(s));
            }
            else{
                int sec=stack.pop();
                int fir=stack.pop();
                if(s.equals("+")){
                    stack.push(fir+sec);
                }
                else if(s.equals("-")){
                    stack.push(fir-sec);
                }
                else if(s.equals("/")){
                    stack.push(fir/sec);
                }
                else{
                    stack.push(fir*sec);
                }
            }
        }
        return stack.peek();
    }
}
//suraj goud rachamalla the great