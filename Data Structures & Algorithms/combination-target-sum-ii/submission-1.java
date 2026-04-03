class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,target,0,0,res,path);
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
            helper(nums,target,i+1,sum,res,path);
            path.remove(Integer.valueOf(nums[i]));
            sum-=nums[i];
            while(i!=nums.length-1 && nums[i]==nums[i+1])
                i++;
        }
            
    }
}
