class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
         List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        helper(nums,target,0,0,res,path);
        return res;
    }
    public void helper(int[] nums,int target,int ind,int sum, List<List<Integer>> res,List<Integer> path){
        if(sum==target){
            res.add(new ArrayList<>(path));
            return;
        }
        if(sum>target)
            return;
        if(ind>nums.length)
            return;
        for(int i=ind;i<nums.length;i++){
            path.add(nums[i]);
            sum+=nums[i];
            helper(nums,target,i,sum,res,path);
            path.remove(Integer.valueOf(nums[i]));
            sum-=nums[i];
        }
            
    }
}
