class Solution {
    public int getSum(int a, int b) {
        do{
            int xor=a^b;
            int and=a&b;
            b=(and<<1);
            a=xor;
            
        }while(b!=0);
    return a;
    }
}
