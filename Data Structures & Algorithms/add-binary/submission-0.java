class Solution {
    public String addBinary(String a, String b) {
        if(b.length()>a.length())
            return addBinary(b,a);
        int aindex=a.length()-1;
        int carry=0;
        StringBuilder sb=new StringBuilder();
        for(int i=b.length()-1;i>=0;i--){
            int aval=a.charAt(aindex)-'0';
            int bval=b.charAt(i)-'0';
            int sum=aval+bval+carry;
            carry=sum/2;
            int rem=sum%2;
            sb.append((char)(rem+48));
            aindex--;
        }
        while(aindex>=0){
            int aval=a.charAt(aindex)-'0';
             int sum=aval+carry;
            carry=sum/2;
            int rem=sum%2;
            sb.append((char)(rem+48));
            aindex--;
        }
        if(carry>0)
            sb.append((char)(carry+48));
        return sb.reverse().toString();
    }
}