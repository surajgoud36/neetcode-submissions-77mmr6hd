class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0;i<cost.length;i++){
            if(gas[i]>=cost[i]){
                if(isPossible(gas,cost,gas[i]-cost[i],i,(i+1)%cost.length))
                    return i;
            }
            
        }
        return -1;
    }

    public boolean isPossible(int[] gas,int[] cost,int g, int s,int i){
        if(i==s)
            return true;
        g+=gas[i];
        if(g>=cost[i]){
            // lets go to the next station
            g-=cost[i];
            i=(i+1)%cost.length;
            return isPossible(gas,cost,g,s,i);
        }
        else{
            return false;
        }
    }
}
