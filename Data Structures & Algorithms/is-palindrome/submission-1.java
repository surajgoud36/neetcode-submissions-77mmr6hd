class Solution {
    public boolean isPalindrome(String s) {
        int len=s.length();
        //System.out.println(len);
        int p1=0,p2=len-1;
        while(p1<=p2){
            while(p1<len&&!(s.charAt(p1)<=90&&s.charAt(p1)>=65||s.charAt(p1)<=122&&s.charAt(p1)>=97||s.charAt(p1)<=57&&s.charAt(p1)>=48))
                p1++;
            while(p2>=0&&!(s.charAt(p2)<=90&&s.charAt(p2)>=65||s.charAt(p2)<=122&&s.charAt(p2)>=97||s.charAt(p2)<=57&&s.charAt(p2)>=48))
                p2--;
            if(p1>len||p2<0)
                break;
            if(Character.toLowerCase(s.charAt(p1))!=Character.toLowerCase(s.charAt(p2)))
                return false;
            p1++;
            p2--;
        }
        return true;
    }
}
