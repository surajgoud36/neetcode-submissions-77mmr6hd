class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(0,nums,res,path);
        return res;
    }
    public void helper(int i,int[] nums,List<List<Integer>> res,List<Integer> path){
        if(i>=nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[i]);
        helper(i+1,nums,res,path);
        path.remove(Integer.valueOf(nums[i]));
        helper(i+1,nums,res,path);    
    }
}
