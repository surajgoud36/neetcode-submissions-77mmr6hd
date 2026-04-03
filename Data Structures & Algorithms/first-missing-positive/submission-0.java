class Solution {
    public int firstMissingPositive(int[] nums) {
        // rearrange negative numbers
        int len=nums.length;
        int count=0;
        int l=0,r=len-1;
        while(l<=r){
            while(l<len && nums[l]<=0)
                l++;
            while(r>=0 && nums[r]>0)
                r--;
            if(l>r)
                break;
            //swap
            int temp=nums[l];
            nums[l]=nums[r];
            nums[r]=temp;
            l++;
            r--;
            
        }
        System.out.println(Arrays.toString(nums)+" count= "+count);
        for(int i=0;i<len;i++){
            if(nums[i]<=0)
                count++;
            else
                break;
        }
        if(count==len)
            return 1;
        for(int i=count;i<len;i++){
            int num=Math.abs(nums[i]);
            if(num-1+count<len){
                if(nums[num-1+count]>0)
                    nums[num-1+count]*=-1;
            }
               
        }
        System.out.println(Arrays.toString(nums));
        for(int i=count;i<len;i++){
            if(nums[i]>0)
                return(i-count+1);
        }
        return (len-count)+1;
    }
}