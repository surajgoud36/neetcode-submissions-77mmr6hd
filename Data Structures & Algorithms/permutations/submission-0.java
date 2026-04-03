class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        helper(0,nums);
        return res;
    }

    public void helper(int i,int[] nums){
        if(i==nums.length){
            res=new ArrayList<>();
            res.add(new ArrayList<>());
            return;
        }
        helper(i+1,nums);
        List<List<Integer>> temp=new ArrayList<>();

        for(List<Integer> x:res){
            for(int j=0;j<x.size()+1;j++){
                List<Integer> temp1=new ArrayList<>(x);
                temp1.add(j,nums[i]);
                temp.add(temp1);
            }
        }
        res=temp;

    }
}
