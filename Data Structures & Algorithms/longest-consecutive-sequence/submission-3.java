class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> visit = new HashSet<>();
        int res=0;
        for(int x:nums){
            set.add(x);
        }
        for(int x:set){
            if(!visit.contains(x)){
                int len=1;
                int nxt=x+1;
                while(set.contains(nxt)){
                    visit.add(nxt);
                    len++;
                    nxt=nxt+1;
                }
                nxt=x-1;
                while(set.contains(nxt)){
                    visit.add(nxt);
                    len++;
                    nxt=nxt-1;
                }
                res=Math.max(res,len);
            }
               
        }
        return res;
    }
    public int longest(int x,Set<Integer> set,Set<Integer> visit,int len){
        //set.remove(Integer.valueOf(x));
        visit.add(Integer.valueOf(x));
        len++;
        if(!visit.contains(x+1) && set.contains(x+1))
            len+=longest(x+1,set,visit,len);
        if(!visit.contains(x-1) && set.contains(x-1))
            len+=longest(x-1,set,visit,len);
        return len;
    }
}
