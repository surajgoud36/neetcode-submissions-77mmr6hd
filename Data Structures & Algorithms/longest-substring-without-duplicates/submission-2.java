class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set =new HashSet<>();
        int max=0,l=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(set.contains(ch)){
                while(s.charAt(l)!=ch){
                    set.remove(s.charAt(l));
                    l++;
                }
                set.remove(s.charAt(l));   
                l++;
                i--;
            }
            else{
                set.add(ch);
                max=Math.max(max,set.size());
            }
        }
         return max;
    }
   
}
