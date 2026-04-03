class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefix[]=new int[nums.length];
        int sum=0,count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            prefix[i]=sum;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(prefix[i]==k){
                count++;
                count+=map.getOrDefault(0,0);
            }
            else {
                int x=prefix[i]-k;
                count+=map.getOrDefault(x,0);
            }
            map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
        }
        return count;
    }
}