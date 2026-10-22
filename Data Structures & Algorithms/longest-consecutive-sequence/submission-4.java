class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> visit = new HashSet<>();
        int res=0;
        for(int x: nums)
            set.add(x);
        for(int x: set){
            if(!visit.contains(x)){
                visit.add(x);
                int len =1;
                int nxt=x+1;
                while(set.contains(nxt)){
                    len++;
                    visit.add(nxt);
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
}
