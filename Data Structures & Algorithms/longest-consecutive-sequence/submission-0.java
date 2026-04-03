class Solution {
    public int longestConsecutive(int[] nums) {
         HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> removed = new HashSet<>();
        int max=0;
        for(int x:nums){
            set.add(x);
        }
        for(Integer x:set){
            if(!removed.contains(x)){
        
                int num=x,len=1,left=x-1,right=x+1;
                
                removed.add(x);
                // go as left as possible 
                while(!removed.contains(left)&&set.contains(left)){
                    len++;
                    removed.add(left);
                    left--;
                }
                // go as right as possible
                while(!removed.contains(right)&&set.contains(right)){
                    len++;
                    removed.add(right);
                    right++;
                }
                max=Math.max(max,len);
            }
        }
        return max;
    }
}
