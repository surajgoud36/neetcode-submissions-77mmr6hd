class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0,totalCost=0;
        for(int i=0;i<gas.length;i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
        }
        if(totalGas-totalCost<0)
            return -1;
        int net=0;
        int start=0;
        for(int i=0;i<gas.length;i++){
            net+=gas[i]-cost[i];
            if(net<0){
                net=0;
                start=i+1;
            }
        }
        return start;
    }
}
