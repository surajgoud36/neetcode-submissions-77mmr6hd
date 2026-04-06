class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0;
        int[] count=new int[127];
        int max=0;
        for(r=0;r<s.length();r++){
            int curr=(int)s.charAt(r);
            if(count[curr]>0){
                while(l<r){
                    if(s.charAt(l)!=s.charAt(r)){
                        count[(int)s.charAt(l)]--;
                        l++;
                    }
                        
                    else{
                        count[(int)s.charAt(l)]--;
                        l++;
                        break;
                    }
                }
                //l=r;
                //reset(count);
                r--;
                continue;
            }
            count[curr]++;
            max=Math.max(max,r-l+1);
        }
        return max;
    }
    public void reset(int[] count){
        Arrays.fill(count,0);
    }
}
