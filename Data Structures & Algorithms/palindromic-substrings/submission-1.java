class Solution {
    int count;
    public int countSubstrings(String s) {
        char[] input=s.toCharArray();
        count=0;
        for(int i=0;i<input.length;i++){
            helper(i,i,input);
            helper(i,i+1,input);
        }
        return count;
    }
     public void helper(int l,int r,char[] input){
       // System.out.println("l= "+l+" r= "+r);
        while(r<input.length && l>=0){
            //System.out.println("l= "+input[l]+" r= "+input[r]+" max= "+max);
            if(input[l]==input[r]){
                count++;
                l--;
                r++;
            }
            else
                break;
        }
    }
}
