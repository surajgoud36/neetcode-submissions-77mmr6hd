class Solution {
    public boolean isUgly(int n) {
        int[] arr= {2,3,5};
        if(n<=0)
            return false;
        for(int x:arr){
            while(n%x==0)
                n=n/x;
        }
        return n==1;
    }
}