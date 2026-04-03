class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res[]=new int[temperatures.length];
        for(int i=temperatures.length-1;i>=0;i--){
            if(stack.isEmpty()){
                res[i]=0;
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i])
                stack.pop();
            if(stack.isEmpty())
                res[i]=0;
            else{
                res[i]=stack.peek()-i;
            }
            stack.push(i);
        }
        return res;
    }
}
