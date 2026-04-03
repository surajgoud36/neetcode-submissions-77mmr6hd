class Solution {
    public int[] plusOne(int[] digits) {
        int len=digits.length;
        int carry=1;
        for(int i=len-1;i>=0;i--){
            int temp=digits[i];
             
            digits[i]=(digits[i]+carry)%10;
            carry=(temp+carry)/10;
           
            if(carry==0)
                break;
        }
        if(carry==1){
            System.out.print(Arrays.toString(digits));
            int res[]=new int[len+1];
            for(int i=1;i<len+1;i++){
                res[i]=digits[i-1];
            }
            res[0]=1;
            return res;
        }
        return digits;

    }
}
