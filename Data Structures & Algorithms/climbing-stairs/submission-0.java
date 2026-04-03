class Solution {
    public int climbStairs(int n) {
        if(n<=2)
            return n;
        int arr[]=new int[2];
        arr[0]=1;
        arr[1]=2;
        for(int i=3;i<=n;i++){
            int temp=arr[1];
            arr[1]=arr[1]+arr[0];
            arr[0]=temp;
        }
        return arr[1];
        
    }
}
