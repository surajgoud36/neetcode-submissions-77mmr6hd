class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix=strs[0];
        for(int i=1;i<strs.length;i++){
            StringBuilder nprefix=new StringBuilder();
            String curr=strs[i];
            int len=Math.min(curr.length(),prefix.length());
            for(int j=0;j<len;j++){
                if(curr.charAt(j)==prefix.charAt(j))
                    nprefix.append(curr.charAt(j));
                else
                    break;
            }
            prefix=nprefix.toString();


        }
        return prefix;
    }
}