class Solution {
    public int rob(int[] nums) {
        int max=0;
        int[] arr=new int[2];
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        if(nums.length==3)
            return Math.max(nums[0],Math.max(nums[1],nums[2]));
        int s1=nums[0];
        boolean i1=true;
        int s2=nums[1];
        boolean i2=false;
        int one=0,two=1;
        if(nums[0]<nums[nums.length-1]){
            s1=nums[1];
            i1=false;
            s2=nums[2];
            i2=false;
            one=1;
            two=2;
        }
        if(nums[two]<nums[one]){
            s2=nums[one];
            i2=i1;
        }
         System.out.println("s1: "+s1+" i1: "+i1+" s2: "+s2+" i2: "+i2);
        for(int i=two+1;i<nums.length;i++){
            if(i!=nums.length-1){
                if(s2>s1+nums[i]){
                    int temps=s1;
                    boolean tempb=i1;
                    s1=s2;
                    i1=i2;
                    s2=s1;
                    i2=i1;
                }
                else{
                    int temps=s1;
                    boolean tempb=i1;
                    s1=s2;
                    i1=i2;
                    s2=temps+nums[i];
                    i2=tempb;
                }
            }
            else{
                // lets determine max 1
                System.out.println("s1: "+s1+" i1: "+i1+" s2: "+s2+" i2: "+i2);
                int sum=s1+nums[i];
                int max1;
                if(i1){
                    max1=Math.max(sum-nums[i],sum-nums[0]);
                }
                else
                    max1=sum;
                // lets determine max 2
                max1=Math.max(max1,s1);
                boolean inc=false;
                if(s2>s1){
                    // 2nd last is added 
                    if(s2-nums[i-1]+nums[i]>s2)
                        inc=true;
                    sum=Math.max(s2,s2-nums[i-1]+nums[i]);
                    if(i2==false)
                        sum=Math.max(sum,s2+nums[0]);
                }
                else {
                     sum=s2+nums[i];
                     if(i2==false)
                        sum=Math.max(sum,s2+nums[0]);
                     inc=true;
                }
                   
                int max2;
                if(i2 && inc){
                    max2=Math.max(sum-nums[i],sum-nums[0]);
                }
                else
                    max2=sum;
                max2=Math.max(max2,s2);
                max=Math.max(max1,max2);
            }
        }
        return max;
    }
}
