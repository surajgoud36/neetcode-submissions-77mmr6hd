class Solution {
    public int lengthOfLongestSubstring(String s) {
         Set<Character> set = new LinkedHashSet<>();
        int len=0,max=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(set.contains(ch)){
                Iterator<Character> it = set.iterator();
                while(it.hasNext() && !it.next().equals(ch)){
                    it.remove();
                    len--;
                }
                it.remove();
                len--;
                set.add(ch);
                len++;
                max=Math.max(len,max);
                //set.clear();
                //set.add(ch);
            }
            else{
                len++;
                max=Math.max(len,max);
                set.add(ch);
            }
        }
        return max;
    }
}
