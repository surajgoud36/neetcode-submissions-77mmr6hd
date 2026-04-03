class Solution {
    List<List<Integer>> res;
    int sum;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res=new ArrayList<>();
        sum=0;
        helper(nums,target,new ArrayList<>(),0);
        return res;
    }

    public void helper(int[] nums,int target,List<Integer> curr,int ind){
        System.out.println("sum = "+sum);
        if(ind==nums.length)
            return;
        if(sum>target)
            return;
        if(sum==target){
            res.add(new ArrayList<>(curr));
            return;
        }

        
        for(int i=ind;i<nums.length;i++){
            sum+=nums[i];
            curr.add(nums[i]);
            helper(nums,target,curr,i);
            //back track
            sum-=nums[i];
            curr.remove(curr.size()-1);

        }
    }
}
