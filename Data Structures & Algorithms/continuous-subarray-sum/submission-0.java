class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int i=0;
        for(int x:nums){
            sum+=x;
            if(map.containsKey(sum%k)){
                if(i-map.get(sum%k)>1)
                    return true;
            }
            else{
                map.put(sum%k,i);
            }
            i++;
            
        }
        return false;
    }
}