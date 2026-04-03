class Solution {
    public int[] countBits(int n) {
        int[] res=new int[n+1];
        res[0]=0;
        int msb=1;
        for(int i=1;i<n+1;i++){
            if(i==(msb*2))
                msb=msb*2;
            res[i]=1+res[i-msb];
        }
        return res;
    }
}
