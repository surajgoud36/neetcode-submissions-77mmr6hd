class Solution {
    public int lengthOfLastWord(String s) {
        boolean space=false;
        int len=0;
        for(int i=s.length()-1;i>=0;i--){
            int curr=(int)s.charAt(i);
            if(curr==32 && !space)
                continue;
            if(curr==32 && space)
                return len;
            len++;
            if(!space)
                space=true;
        }
        return len;
    }
}