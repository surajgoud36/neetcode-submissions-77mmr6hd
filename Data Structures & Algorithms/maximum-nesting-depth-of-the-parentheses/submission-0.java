class Solution {
    public int maxDepth(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                stack.push(1);
                max=Math.max(max,stack.size());
            }
            else if(ch==')')
                stack.pop();
            
                
        }
        return max;
    }
}