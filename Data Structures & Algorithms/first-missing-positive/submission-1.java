class Solution {
    public int firstMissingPositive(int[] nums) {
        // rearrange negative numbers
        int len=nums.length;
        int count=0;
        int l=0,r=len-1;
        
        for(int i=0;i<len;i++){
            if(nums[i]<0)
                nums[i]=0;
            
        }
       
        for(int i=0;i<len;i++){
            int num=Math.abs(nums[i]);
            if(num-1<0 || num-1>=len)
                continue;
            if(nums[num-1]==0)
                nums[num-1]=-1*(len+1);
            else{
                if(nums[num-1]>0)
                    nums[num-1]*=-1;
            }
            
               
        }
        
        for(int i=0;i<len;i++){
            if(nums[i]>=0)
                return (i+1);
        }
        return len+1;
        
        
    }
}