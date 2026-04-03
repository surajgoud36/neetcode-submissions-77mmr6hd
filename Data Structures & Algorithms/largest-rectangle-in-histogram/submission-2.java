record Pair(int val,int freq){}
class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Pair> stack=new ArrayDeque<>();
        int max=heights[0]*1;
        for(int i=heights.length-1;i>=0;i--){
            Pair curr=new Pair(heights[i],1);
            if(stack.isEmpty()){
                stack.push(curr);
                max=Math.max(max,curr.val()*curr.freq());
                continue;
            }
            if(stack.peek().val()<curr.val()){
                stack.push(curr);
                max=Math.max(max,curr.val()*curr.freq());
            }
            else{
                int cf=0;
                while(!stack.isEmpty() && stack.peek().val()>=curr.val()){
                    Pair popped=stack.pop();
                    max=Math.max(max,popped.val()*(popped.freq()+cf));
                    cf+=popped.freq();
                }
                Pair np=new Pair(heights[i],cf+1);
                stack.push(np);
                max=Math.max(max,np.val()*np.freq());
            }
        }
        //System.out.println(stack);
        int nf=0;
        while(!stack.isEmpty()){
            Pair curr=stack.pop();
            max=Math.max(max,curr.val()*(curr.freq()+nf));
            nf+=curr.freq();
        }
        return max;

    }
}