class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int max=Math.min(str1.length(),str2.length());
        for(int i=max;i>0;i--){
            if(checkCandidate(str1,str2,i))
                return str1.substring(0,i);
        }
        return "";
    }
    public boolean checkCandidate(String s1,String s2,int l){
        int l1=s1.length(),l2=s2.length();
        if(l1%l!=0 || l2%l!=0)
            return false;
        int c1=l1/l,c2=l2/l;
        StringBuilder can=new StringBuilder(s1.substring(0,l));
        String temp = s1.substring(0,l);
        for(int i=1;i<c1;i++)
            can.append(temp);
        if(!s1.equals(can.toString()))
            return false;
        can.setLength(0);
        
        for(int i=0;i<c2;i++){
            can.append(temp);
        }
        return s2.equals(can.toString());
    }
}