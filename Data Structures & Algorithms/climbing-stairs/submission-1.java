class Solution {
    public int climbStairs(int n) {
        int[] temp = new int[2];
        temp[0]=1;
        temp[1]=2;
        if(n<=2)
            return temp[n-1];
        for(int i=2;i<n;i++){
            int req=temp[0]+temp[1];
            temp[0]=temp[1];
            temp[1]=req;
        }
        return temp[1];
    }
}
