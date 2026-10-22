class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0,r=0;
        Set<Character> set = new HashSet<>();
        int max=0;
        for(r=0;r<s.length();r++){
            char ch = s.charAt(r);
            if(!set.contains(ch)){
                max=Math.max(max,r-l+1);
                set.add(ch);
            }
            else{
                set.remove(s.charAt(l));
                l++;
                r--;
            }
        }
        return max;
    }
}
