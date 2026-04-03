class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count=new int[26];
        for(char x:s.toCharArray()){
            count[x-'a']++;
        }
        for(char x: t.toCharArray()){
            count[x-'a']--;
            if(count[x-'a']<0)
                return false;
        }
        for(int x:count){
            if(x!=0)
                return false;
        }
        return true;
    }
}
