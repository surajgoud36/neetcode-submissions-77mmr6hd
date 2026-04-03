class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int x:nums){
            if(map.size()==2 && !map.containsKey(x)){
                Iterator<Map.Entry<Integer,Integer>> iterator=map.entrySet().iterator();
                while(iterator.hasNext()){
                    Map.Entry<Integer,Integer> entry=iterator.next();
                    if(entry.getValue()==1){
                        iterator.remove();
                        continue;
                    }
                    map.put(entry.getKey(),entry.getValue()-1);
                }
            }
            map.put(x,map.getOrDefault(x,0)+1);

        }
        int target=(int)Math.floor(nums.length/3.0)+1;
        List<Integer> res=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(freq(nums,entry.getKey())>=target)
                res.add(entry.getKey());
        }
        return res;
    }
    public int freq(int[] nums,int ele){
        int count=0;
        for(int x:nums){
            if(x==ele)
                count++;
        }
        return count;
    }
}