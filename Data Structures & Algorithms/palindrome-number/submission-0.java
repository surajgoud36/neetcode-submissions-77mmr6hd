class Solution {
    public boolean isPalindrome(int x) {
        int rev=0;
        if(x<0)
            return false;
        x=Math.abs(x);
        int temp=x;
        while(temp!=0){
            rev=(rev*10)+(temp%10);
            temp/=10;
        }
        return rev==x;
    }
}