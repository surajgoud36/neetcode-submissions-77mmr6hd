class Solution {
    public int reverseBits(int n) {
        // we go over each bit of n from oth bit to 31st bit
        int res=0;
        for(int i=0;i<32;i++){
            int bit=(n>>i)&1;
            res=res|(bit<<(31-i));
        }
        return res;
    }
}
