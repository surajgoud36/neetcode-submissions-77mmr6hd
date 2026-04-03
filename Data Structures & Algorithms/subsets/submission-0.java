class Solution {
    List<List<Integer>> blist;
    public List<List<Integer>> subsets(int[] nums) {
        blist=new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return blist;
    }
    public void helper(int[] nums,int i,List<Integer> list){
        if(i==nums.length){
            //System.out.println(list);
              blist.add(new ArrayList<>(list));
               //System.out.println("BList: "+blist);
              return;
        }

        list.add(nums[i]);
        helper(nums,i+1,list);
        list.remove(list.size()-1);
        helper(nums,i+1,list);
          
    }
}
