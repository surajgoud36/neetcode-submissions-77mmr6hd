class Solution {
    int max=0;
    String res;
    int start,length;
    public String longestPalindrome(String s) {
        char[] input=s.toCharArray();
        res=""+s.charAt(0);
        start=0;
        length=1; 
        for(int i=0;i<input.length;i++){
            helper(i,i,input);
            helper(i,i+1,input);
        }
        return new String(input,start,length);
    }

    public void helper(int l,int r,char[] input){
       // System.out.println("l= "+l+" r= "+r);
        while(r<input.length && l>=0){
            //System.out.println("l= "+input[l]+" r= "+input[r]+" max= "+max);
            if(input[l]==input[r]){
                if((r-l+1)>max){
                    max=r-l+1;
                    //res=new String(input,l,(r-l+1));
                    start=l;
                    length=r-l+1;
                }
                l--;
                r++;
            }
            else
                break;
        }
    }
}
