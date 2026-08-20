class Solution {
    Map<Integer,Integer> map;
    public int subarraysWithKDistinct(int[] nums, int k) {
        map=new HashMap<>();
        int l=0,r=0,lr=0;
        int res=0;
        while(r<nums.length){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                int count = map.get(nums[lr]);
                if(count ==1)
                    map.remove(nums[lr]);
                else
                    map.put(nums[lr],count-1);
                lr++;
                l=lr;
            }
            if(map.size() == k)
                res+=(lr-l+1);
            while(map.size()==k && map.get(nums[lr])>1){
                res+=1;
                 map.put(nums[lr],map.get(nums[lr])-1);
                lr++;
               
            }
            r++;
            
        }
        return res;
    }
    

}