class Solution {
    public int rob(int[] nums) {
        
        int max=0;
        int[] arr=new int[2];
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        // l to r
       // nums[1]=Math.max(nums[0],nums[1]);
        int p1=nums[0];
        int p2=Math.max(nums[0],nums[1]);
        int max1=0,max2=0;
        for(int i=2;i<nums.length;i++){
            if(i!=nums.length-1){
                int temp=Math.max(p2,p1+nums[i]);
                p1=p2;
                p2=temp;
            }
            else{
                // if(p2<p1+nums[i]){
                //     int temp=p1+nums[i];

                // }
                int temp=Math.max(p2,p1+nums[i]);
                int min=Math.min(nums[0],nums[i]);
                max1=Math.max(p2,temp-min);
            }
           

            //max=Math.max(max,nums[i]);
        }
         // l to r
       // nums[1]=Math.max(nums[0],nums[1]);
         p1=nums[nums.length-1];
         p2=Math.max(nums[nums.length-1],nums[nums.length-2]);
        
        for(int i=nums.length-3;i>=0;i--){
            if(i!=0){
                int temp=Math.max(p2,p1+nums[i]);
                p1=p2;
                p2=temp;
            }
            else{
                // if(p2<p1+nums[i]){
                //     int temp=p1+nums[i];

                // }
                int temp=Math.max(p2,p1+nums[i]);
                int min=Math.min(nums[nums.length-1],nums[i]);
                max2=Math.max(p2,temp-min);
            }
           

            //max=Math.max(max,nums[i]);
        }
        return Math.max(max1,max2);
    }
}
