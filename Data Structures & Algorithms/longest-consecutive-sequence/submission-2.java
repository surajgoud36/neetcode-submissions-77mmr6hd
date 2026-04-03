class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
            return 0;
        Map<Integer,Integer> ele=new HashMap<>();
        Set<Integer> visit=new HashSet<>();
        int max=Integer.MIN_VALUE;
        for(int x:nums){
            ele.put(x,1);
        }
        for(int i=0;i<nums.length;i++){
            int val=0;
            if(!visit.contains(nums[i])){
               val=ele.get(nums[i])+countLength(nums[i]+1,visit,ele);
               ele.put(nums[i],val);
               visit.add(nums[i]);
            }
               
            else
                val=ele.get(nums[i]);
            max=Math.max(val,max);
        }
        return max;
    }
    public int countLength(int curr,Set<Integer> visit,Map<Integer,Integer> ele){
        if(visit.contains(curr))
            return ele.get(curr);
        if(!ele.containsKey(curr))
            return 0;
        visit.add(curr);
        int val=ele.get(curr)+countLength(curr+1,visit,ele);
        ele.put(curr,val);
        return val;
        
    }
}
