class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==2)
            return cost[0];
        int[] arr=new int[2];
        arr[0]=cost[0];
        arr[1]=cost[1];
        for(int i=2;i<cost.length;i++){
            int temp=arr[1];
            arr[1]=Math.min(arr[1]+cost[i],arr[0]+cost[i]);
            arr[0]=temp;
        }
        return Math.min(arr[1],arr[0]);
        //return 0;
    }
}
