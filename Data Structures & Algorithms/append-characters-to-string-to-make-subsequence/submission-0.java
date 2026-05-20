class Solution {
    public int appendCharacters(String s, String t) {
        int i1=0,i2=0;
        int l1=s.length(),l2=t.length();

        while(i1<l1 && i2<l2){
            if(s.charAt(i1)==t.charAt(i2)){
                i2++;
            }
            i1++;
        }
        return l2-i2;
    }
}