class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int sum=0;
        int[] sets=new int[k];
        for(int x: nums){
            sum+=x;
        }
        if(sum%k!=0)
            return false;
        int targetLength= sum/k;
        return helper(nums,sets,0,targetLength);
    }
    public boolean helper(int[] nums, int[] sets,int index,int target){
        if(index>=nums.length)
            return true;
        for(int i=0;i<sets.length;i++){
            if(sets[i]+nums[index]<=target){
                sets[i]+=nums[index];
                if(helper(nums,sets,index+1,target))
                    return true;
                sets[i]-=nums[index];
                
            }
            while(i!=sets.length-1 && sets[i]==sets[i+1])
                i++;
        }
        return false;
    }
    public void reverse(int[] nums){
        int l=0,h=nums.length-1;
        while(l<h){
            int temp=nums[l];
            nums[l]=nums[h];
            nums[h]=temp;
            l++;
            h--;
        }
    }
}