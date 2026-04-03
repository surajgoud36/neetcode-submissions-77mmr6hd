class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list= new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int target=-1*nums[i];
            int p1=i+1;
            int p2=nums.length-1;
            while(p1<p2){
                if((nums[p1]+nums[p2])==target){
                    if(!list.contains(Arrays.asList(nums[i],nums[p1],nums[p2])))
                        list.add(new ArrayList<>(Arrays.asList(nums[i],nums[p1],nums[p2])));
                    p1++;
                }
                else if((nums[p1]+nums[p2])>target)
                    p2--;
                else 
                p1++;
            }
        }
        return list;
    }
}
