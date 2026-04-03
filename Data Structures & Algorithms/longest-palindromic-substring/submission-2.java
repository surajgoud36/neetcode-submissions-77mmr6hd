class Solution {
    public String longestPalindrome(String s) {
        int len=s.length();
        String even="";
        String odd="";
        int max=0,lower=0,upper=0;
        for(int i=0;i<len;i++){
            int[] left=helper(i,i,s);
            int[] right=helper(i,i+1,s);
            if(left[0]>right[0]){
                if(left[0]>max){
                    max=left[0];
                    lower=left[1];
                    upper=left[2];
                }
            }
            else{
                if(right[0]>max){
                    max=right[0];
                    lower=right[1];
                    upper=right[2];
                }
            }
        }
        return s.substring(lower,Math.min(upper+1,len));
    }

    public int[] helper(int l,int r,String s){
        int maxlen=1,left=l,right=r;
        while(l>=0 && r<s.length()){
            if(s.charAt(l)!=s.charAt(r))
                break;
            left=l;
            right=r;
            maxlen=r-l+1;
            l--;
            r++;
        }
        if(maxlen==1)
            right=left;
        int res[]=new int[]{maxlen,left,right};
        return res;
    }
}
