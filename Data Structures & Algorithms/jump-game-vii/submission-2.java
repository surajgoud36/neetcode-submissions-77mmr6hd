class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        char[] sArray=s.toCharArray();
        int len=sArray.length;
        if(sArray[0]=='1'||sArray[len-1]=='1')
            return false;
        Queue<Integer> queue=new ArrayDeque<Integer>();
        queue.add(0);
        int farthest=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            //System.out.println("queue= "+queue+" farthest= "+farthest);
            for(int i=0;i<size;i++){
                int index=queue.poll();
                if(index==len-1)
                    return true;
                if(sArray[index]!='1'){
                    int start=Math.max(index+minJump,farthest+1);
                    int end=Math.min(index+maxJump,len-1);
                    for(int j=start;j<=end;j++){
                        queue.add(j);
                        farthest=j;
                    }
                        
                }
            }
        }
        return false;
    }
}