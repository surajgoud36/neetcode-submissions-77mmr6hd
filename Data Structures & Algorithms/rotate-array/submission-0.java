class Solution {
    public void rotate(int[] nums, int k) {
        int len=nums.length;
        k=k%len;
        if(k==0)
            return;
        int count=0,ind=0,ele=nums[ind];
        for(int start=0;count<len;start++){
            int current=start;
            int prev=nums[start];
            do{
                int nextInd=(current+k)%len;
                int temp=nums[nextInd];
                nums[nextInd]=prev;
                prev=temp;
                count++;
                current=nextInd;
            }while(start!=current);
        }
        // while(count<len){
        //     int temp=nums[(ind+k)%len];
        //     nums[(ind+k)%len]=ele;
        //     //nums[ind]=temp
        //     count++;
        //     ele=temp;
        //     ind=(ind+k)%len;

        // }
    }
}