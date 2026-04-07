class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int max=0;
        for(int x:nums){
            if(count==0){
                max=x;
                count=1;
            }
            else if(x!=max){
                count--;
            }
            else
                count++;
        }
        return max;
    }
}