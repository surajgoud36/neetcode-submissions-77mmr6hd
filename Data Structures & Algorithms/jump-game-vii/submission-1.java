class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        // keep track of the nearest 0th index from which we can jump till the end
        int len=s.length();
        
        char[] arr=s.toCharArray();
        if(arr[len-1]=='1')
            return false;
        
      int low=0,high=0;
      while(low!=-1 && high!=-1&& low<len && high<len && low<=high){
        int tempLow=-1,tempHigh=-1;
        for(int i=low;i<=high;i++){
            //System.out.println("i="+i);
            if(arr[i]=='0' && i==len-1)
                return true;
            if(arr[i]=='1')
                continue;
            if(tempLow==-1 && i+minJump>high)
                tempLow=i+minJump;
            if(i+maxJump>high)
                tempHigh=Math.min(i+maxJump,len-1);
        }
        low=tempLow;
        high=tempHigh;
        if(low==-1 && high==-1)
            return false;
        if(low==-1)
            low=high;
      }
      return false;
    }
}