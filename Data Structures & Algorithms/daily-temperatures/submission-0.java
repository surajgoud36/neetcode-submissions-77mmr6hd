class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len=temperatures.length;
        ArrayDeque<Integer> deq=new ArrayDeque<>();
        int res[]=new int[len];
        res[len-1]=0;
        deq.push(len-1);
        for(int i=len-2;i>=0;i--){
            while(deq.isEmpty()==false&&temperatures[deq.peek()]<=temperatures[i]){
                deq.pop();
            }
            if(deq.isEmpty()){
                res[i]=0;
            }
            else{
                res[i]=deq.peek()-i;
            }
            deq.push(i);
        }
        return res;
    }
}
