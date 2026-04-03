class Solution {
    public int characterReplacement(String s, int k) {
        int[] count=new int[26];
        int l=0,res=0;
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'A']++;
            int size=i-l+1;
            int max=determineMax(count);
            if(size-max>k){
                count[s.charAt(l)-'A']--;
                count[s.charAt(i)-'A']--;
                l++;
                i--;
            }
            else{
                res=Math.max(res,i-l+1);
            }
        }
        return res;
    }

    //determine max
    public int determineMax(int[] arr){
        int max=0;
        for(int x:arr){
            max=Math.max(max,x);
        }
        return max;
    }
}