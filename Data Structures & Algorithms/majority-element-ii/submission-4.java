class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int x:nums){
            if(map.size()==2 && !map.containsKey(x)){
                Iterator<Map.Entry<Integer,Integer>> itr=map.entrySet().iterator();
                while(itr.hasNext()){
                    Map.Entry<Integer,Integer> entry=itr.next();
                    int val=entry.getValue()-1;
                    if(val==0){
                        itr.remove();
                        continue;
                    }
                    map.put(entry.getKey(),val);
                        
                }
            }
            else{
                map.put(x,map.getOrDefault(x,0)+1);
            }
        }
        int target=(int)Math.floor(nums.length/3.0)+1;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int fre=freq(nums,entry.getKey());
            if(fre>=target)
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