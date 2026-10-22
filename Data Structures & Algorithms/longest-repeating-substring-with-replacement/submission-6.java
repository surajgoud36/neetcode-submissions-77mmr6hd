class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int max=0;
        int l=0;
        for(int r=0;r<s.length();r++){
            if(canInclude(freq,s,k,r)){
                max=Math.max(max,r-l+1);
            }
            else{
                r--;
                int ind = s.charAt(l)-'A';
                freq[ind]--;
                l++;
            }
        }
        return max;
    }
    public boolean canInclude(int[] freq,String s,int k,int i){
        int ind = s.charAt(i)-'A';
        freq[ind]++;
        int total =0;
        int max=0;
        for(int j=0;j<26;j++){
            total+=freq[j];
            max=Math.max(max,freq[j]);
        }
        //freq[ind]--;
        if(total-max>k){
            freq[ind]--;
            return false;
        }
            
        return true;
    }
}
