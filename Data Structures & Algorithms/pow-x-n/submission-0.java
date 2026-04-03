class Solution {
    public double myPow(double x, int n) {
        if(n==0)
            return 1.0;
        if(x==0)
            return 0.0;
        int N=Math.abs(n);
        double res=power(x,N);
        if(n<0)
            return (1/res);
        return res;

    }

    public double power(double x,int n){
        //base case
        if(n==0)
            return 1;
        if(n%2!=0)
            return x*power(x,n-1);
        double temp=power(x,n/2);
        return temp*temp;

    }
}
