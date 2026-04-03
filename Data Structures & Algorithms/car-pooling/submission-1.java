class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
         int L = Integer.MAX_VALUE, R = Integer.MIN_VALUE;
        for (int[] trip : trips) {
            L = Math.min(L, trip[1]);
            R = Math.max(R, trip[2]);
        }
        int N=R-L+1;
        int[] passChange = new int[N+1];
        for(int[] trip:trips){
            passChange[trip[1]-L]+=trip[0];
            passChange[trip[2]-L]-=trip[0];
        }
        int curr=0;
        for(int change:passChange){
            curr+=change;
            if(curr>capacity)
                return false;
        }
        return true;
    }
}