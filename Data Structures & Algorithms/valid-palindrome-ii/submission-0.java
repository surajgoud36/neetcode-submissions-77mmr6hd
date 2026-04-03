class Solution {
    int count=0;
    public boolean validPalindrome(String s) {
        int l=0,r=s.length()-1;
        while(l<r){
            char a=s.charAt(l);
            char b=s.charAt(r);
            if(a==b){
                l++;
                r--;
                continue;
            }
            if(a!=b && count!=0)
                return false;
            else{
                count++;
                return validPalindrome(s.substring(l+1,r+1)) || validPalindrome(s.substring(l,r));
            }

        }
        return true;
    }
}