class Solution {
    public int firstUniqChar(String s) {
        int[] count=new int[26];
        for(int i=0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        int res=Integer.MAX_VALUE;
        boolean flag=false;
        for(int i=0;i<26;i++){
            if(count[i]==1){
                char req=(char)('a'+i);
                int temp= s.indexOf(req);
                flag=true;
                if(temp<res)
                    res=temp;
            }
        }
        if(!flag)
            return -1;
        return res;
    }
}