class Solution {
    public void moveZeroes(int[] nums) {
        int i1=0,i2=0;
        int len=nums.length;

        while(i1<len && i2<len){
            while(i1<len && nums[i1]!=0){
                i1++;
            }
            i2=i1+1;
            while(i2<len && nums[i2]==0)
                i2++;
            if(i1<len && i2<len){
                nums[i1]=nums[i2];
                nums[i2]=0;
            }
            else
                break;
        }
        
    }
}