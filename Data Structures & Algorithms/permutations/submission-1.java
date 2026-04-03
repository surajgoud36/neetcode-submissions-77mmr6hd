class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permutation(nums,0);
    }
    public List<List<Integer>> permutation(int[] nums,int index){
        List<List<Integer>> res;
        if(index==nums.length){
            res=new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }

        res=permutation(nums,index+1);
        List<List<Integer>> finalRes=new ArrayList<>();
        for(List<Integer> entry:res){
            for(int i=0;i<entry.size()+1;i++){
                List<Integer> temp=new ArrayList<>(entry);
                temp.add(i,nums[index]);
                finalRes.add(temp);
            }
        }
        return finalRes;
    }
}
