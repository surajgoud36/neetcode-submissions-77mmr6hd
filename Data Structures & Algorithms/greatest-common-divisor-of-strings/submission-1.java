class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1=str1.length();
        int len2=str2.length();
        if(len1<len2)
            return gcdOfStrings(str2,str1);
        for(int i=str2.length();i>0;i--){
            String candidate = str2.substring(0,i);
           
            if(checkCandidate(str2,candidate) && checkCandidate(str1,candidate))
                return candidate;
        }
        return "";
    }
    public boolean checkCandidate(String str,String s){
        int target=str.length();
        int index=str.indexOf(s);
        while(index!=-1 && index<target){
            index=index+s.length();
            if(index==target)
                break;
            index=str.indexOf(s,index);
        }
       
        return index==target;
    }
}