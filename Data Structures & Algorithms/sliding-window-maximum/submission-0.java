class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int n=nums.length;
        int[] res=new int[n-k+1];
        int l=0,r=(l+k)-1,counter=1;
        for(int i=l;i<=r;i++){
            map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
        }
        res[0]=map.lastKey();
        for(int i=r+1;i<n;i++){
            if(map.get(nums[l])==1)
                map.remove(nums[l]);
            else
                map.put(nums[l],map.get(nums[l])-1);
            map.put(nums[i],map.getOrDefault(nums[i], 0)+1);
            l++;
            res[counter++]=map.lastKey();
        }
        return res;
    }   
}
