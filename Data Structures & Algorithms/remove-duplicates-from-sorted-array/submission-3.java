class Solution {
    public int removeDuplicates(int[] nums) {
        int prev=nums[0],k=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==prev){
                nums[i]=101;
                k++;
            }
                
            else
                prev=nums[i];
        }
        System.out.println(Arrays.toString(nums));
       int first=-1;
       int ele=-1,one=0;
       while(true){
        while(first==-1 && one<nums.length && nums[one]!=101){
            one++;
        }
        if(one<nums.length){
            first=one;
            //ele++;
            one++;
        }
        else
            break;
        if(ele==-1 || ele<one)
            ele=one;
        while(ele<nums.length && nums[ele]==101)
            ele++;
        if(ele<nums.length){
            int temp=nums[ele];
            nums[ele]=nums[first];
            nums[first]=temp;
        }
        else 
            break;
       }
        System.out.println(Arrays.toString(nums));
        return nums.length-k;
    }
}