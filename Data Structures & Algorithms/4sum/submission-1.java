class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            res.addAll(threeSum(nums,target-nums[i],i+1,nums[i]));
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums, long target,int start,int ele){
        List<List<Integer>> res=new ArrayList<>();
        for(int i=start;i<nums.length;i++){
            if(i!=start && nums[i]==nums[i-1])
                continue;
            res.addAll(twoSum(nums,target-nums[i],i+1,nums[i],ele));
        }
        return res;
    }

    public List<List<Integer>> twoSum(int[] nums, long target,int start,int ele,int prevEle){
        List<List<Integer>> res=new ArrayList<>();
        int low=start,high=nums.length-1;
        while(low<high){
            if(nums[low]+nums[high]==target){
                res.add(new ArrayList<>(Arrays.asList(prevEle,ele,nums[low],nums[high])));
                low++;
                while(low<high && nums[low-1]==nums[low])
                    low++;
            }
            else if(nums[low]+nums[high]<target)
                low++;
            else
                high--;
        }
        return res;
    }
}