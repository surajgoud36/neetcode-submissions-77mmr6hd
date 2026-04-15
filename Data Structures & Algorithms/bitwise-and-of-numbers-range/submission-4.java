class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int res=0;
        int accLeft=0;
        int i=0;
        int diff=right-left;
        int actualLeft=left;
        while(left!=0){
            int digit=(left&1);
            accLeft=accLeft|digit<<i;
            if(digit==0){
                res=res|digit<<i;
            }
            else{
                int nextPower=(1<<(i+1));
                int powerDiff=nextPower-accLeft;
                if((right-actualLeft)>=powerDiff)
                    res=res|0<<i;
                else
                    res=res|1<<i;
            }
            i++;
            left=left>>1;
        }
        return res;
    }
}