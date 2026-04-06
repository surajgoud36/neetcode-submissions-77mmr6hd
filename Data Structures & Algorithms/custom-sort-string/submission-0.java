class Solution {
    public String customSortString(String order, String s) {
        int[] count=new int[26];
        for(char ch:s.toCharArray()){
            count[ch-'a']++;
        }
        StringBuilder res=new StringBuilder();
        for(char ch:order.toCharArray()){
            for(int i=0;i<count[ch-'a'];i++){
                res.append(ch);
            }
            count[ch-'a']=0;
        }
        for(int i=0;i<26;i++){
            while(count[i]>0){
                res.append((char)('a'+i));
                count[i]--;
            }
        }
        return res.toString();
    }
}