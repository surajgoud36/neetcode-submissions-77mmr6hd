class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasT=0;
        int costT=0;
        for(int i=0;i<gas.length;i++){
            costT+=cost[i];
            gasT+=gas[i];
        }
        if(costT>gasT)
            return -1;
        int index=0,tot=0;
        for(int i=0;i<gas.length;i++){
            tot+=gas[i]-cost[i];
            if(tot<0){
                tot=0;
                index=i+1;
            }
        }
        return index;
    }
}
