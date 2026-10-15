class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int len = nums.length;
        for(int i=len-1;i>=0;i--){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
                update(map,nums[i]);
            }
            else{
                int prevCount = map.get(nums[i]);
                Integer next = map.higherKey(nums[i]);
                if(next!=null && map.get(next)+1 > prevCount)
                    map.put(nums[i],map.get(next)+1);
                remove(map,nums[i]);
            }
        }
        int max=0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
            max=Math.max(max,entry.getValue());
        return max;
    }
    public void update( TreeMap<Integer,Integer> map,int key){
        if(map.higherKey(key)!=null){
            int tKey = map.higherKey(key);
            map.put(key,map.get(key)+map.get(tKey));
        }
        remove(map,key);
    }
    public void remove( TreeMap<Integer,Integer> map,int key){
        Integer temp = map.lowerKey(key);
        int val = map.get(key);
        while(temp!=null && map.get(temp)<val){
            map.remove(temp);
            temp = map.lowerKey(key);
        }
    }
}
