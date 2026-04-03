class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i1=0,i2=0,c=1;
        String word="";
        while(i1<word1.length() && i2<word2.length()){
            if(c%2!=0){
                word+=word1.charAt(i1++);
            }
            else{
                 word+=word2.charAt(i2++);
            }
            c++;
        }
        if(i1<word1.length())
            word+=word1.substring(i1);
        if(i2<word2.length())
            word+=word2.substring(i2);
        return word;
    }
}