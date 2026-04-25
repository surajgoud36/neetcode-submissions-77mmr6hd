class Solution {
    int count;
    public int countSubstrings(String s) {
        count=0;
         for(int i=0;i<s.length();i++){
            checkPallindrome(s,i,i);
            checkPallindrome(s,i,i+1);
        }
        return count;
    }
    public void checkPallindrome(String s,int l,int r){
        int len=s.length();
        while(l>=0 && r<len){
            if(s.charAt(l)==s.charAt(r)){
                count++;
                l--;
                r++;
            }
            else
                break;
        }
    }
}
