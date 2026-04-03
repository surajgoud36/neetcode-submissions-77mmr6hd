class Solution {
    public boolean canPartition(int[] nums) {
        int sum=Arrays.stream(nums).sum();
        Map<String,Boolean> map=new HashMap<>();
        if(sum%2!=0)
            return false;
        return helper(nums,0,sum/2,map);
        //return false;
    }

    public boolean helper(int[] nums,int i,int sum,Map<String,Boolean> map){
        if(map.containsKey(String.valueOf(i)+String.valueOf(sum)))
            return map.get(String.valueOf(i)+String.valueOf(sum));
        if(sum==0)
            return true;
        if(sum<0)
            return false;
        if(i>=nums.length)
            return false;
        map.put(String.valueOf(i)+String.valueOf(sum),helper(nums,i+1,sum,map)||helper(nums,i+1,sum-nums[i],map)) ;
        return map.get(String.valueOf(i)+String.valueOf(sum));
    }
}
