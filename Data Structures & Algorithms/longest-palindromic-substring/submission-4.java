class Solution {
    String res;
    int max,lmax,rmax;
    public String longestPalindrome(String s) {
        res="";
        max=0;
        lmax=0;rmax=0;
        for(int i=0;i<s.length();i++){
            checkPallindrome(s,i,i);
            checkPallindrome(s,i,i+1);
        }
        return s.substring(lmax,rmax+1);
    }
    public void checkPallindrome(String s,int l,int r){
        int len=s.length();
        while(l>=0 && r<len){
            if(s.charAt(l)==s.charAt(r)){
                if(max<(r-l+1)){
                    max=r-l+1;
                    lmax=l;
                    rmax=r;
                }
                l--;
                r++;
            }
            else
                break;
        }
    }
    
}
