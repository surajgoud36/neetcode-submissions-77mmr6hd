class Solution {
    public long minEnd(int n, int x) {
        if(n==1)
            return x;
        long guy=x;
        for(int i=0;i<n-1;i++){
            long nextGuy=(guy+1)|x;
            guy=nextGuy;
        }
        return guy;
    }
}