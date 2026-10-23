class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] count = new int[21];
        Arrays.fill(count,0);
        for(int amt: bills){
            int rem = amt - 5;
            count[amt]++;
            int curr=10;
            while(rem>0 && curr>=5){
                if(count[curr]>0 && rem-curr>=0){
                    rem-=curr;
                    count[curr]--;
                }
                else{
                    curr-=5;
                }
            }
            if(rem!=0)
                return false;
        }
        return true;
    }
}