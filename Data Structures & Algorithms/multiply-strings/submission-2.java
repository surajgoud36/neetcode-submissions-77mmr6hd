class Solution {
    public String multiply(String num1, String num2) {
        int len1=num1.length(),len2=num2.length();
        if(len2>len1)
            return multiply(num2,num1);
        if(num1.equals("0")||num2.equals("0"))
            return "0";
        int sum=0,mul=1;
        String s="0";
        String t="";
        for(int i=len2-1;i>=0;i--){
            int n=num2.charAt(i)-'0';
            int carry=0;
            int multiplier=1;
            String res=t;
            for(int j=len1-1;j>=0;j--){
                int m=num1.charAt(j)-'0';
                int rem=((n*m)+carry)%10;
                carry=((n*m)+carry)/10;
               
                res=String.valueOf(rem)+res;
                //multiplier*=10;
            }
            if(carry!=0)
                res=String.valueOf(carry)+res;
            s=add(s,res);
           // mul*=10;
           t+="0";
        }
        //System.out.println("Sum check: "+add("999","999"));
        return s;
    }
    public String add(String num1, String num2){
        int len1=num1.length(),len2=num2.length();
        if(len2>len1)
            return add(num2,num1);
        int carry=0;
        int i1=len1-1,i2=len2-1;
        String ans="";
        for(int i=i2;i>=0;i--){
            int n=num2.charAt(i)-'0';
            int m=num1.charAt(i1)-'0';
            int res=n+m+carry;
            carry=res/10;
            ans=String.valueOf(res%10)+ans;
            i1--;
        }
        while(i1>=0){
            int m=num1.charAt(i1)-'0';
            int res=m+carry;
            carry=res/10;
            ans=String.valueOf(res%10)+ans;
            i1--;
        }
        if(carry!=0)
            ans=String.valueOf(carry)+ans;
        return ans;
    }
}
