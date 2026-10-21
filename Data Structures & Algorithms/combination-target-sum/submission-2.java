class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        dfs(res,0,target,new ArrayList<>(),nums,0);
        return res;
    }

    public void dfs(List<List<Integer>> res,int i,int target,List<Integer> cur,int[] nums,int sum){
        if(sum == target){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(sum>target)
            return;
        for(int j=i;j<nums.length;j++){
            cur.add(nums[j]);
            dfs(res,j,target,cur,nums,sum+nums[j]);
            cur.remove(Integer.valueOf(nums[j]));
            //dfs(res,j+1,k,cur,n);
        }
    }
}
