class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)
            return "";
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            String nprefix="";
            int len=Math.min(prefix.length(),strs[i].length());
            for(int j=0;j<len;j++){
                if(prefix.charAt(j)==strs[i].charAt(j))
                    nprefix+=prefix.charAt(j);
                else
                    break;
            }
            prefix=nprefix;
            if(nprefix=="")
                break;
        }
        return prefix;
    }
}