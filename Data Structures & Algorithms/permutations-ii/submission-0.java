class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        res=new ArrayList<>();
        helper(new ArrayList<>(),nums, new boolean[nums.length]);
        return res;
    }

    public void helper(List<Integer> list,int[] nums,boolean[] visited){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int j=0;j<nums.length;j++){
            if(!visited[j]){
                list.add(nums[j]);
                visited[j]=true;
                helper(list,nums,visited);
                visited[j]=false;
                list.remove(list.size()-1);
                while(j<nums.length-1 && nums[j]==nums[j+1])
                    j++;
            }
        }
    }
}