class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res=new int[2];
        Arrays.fill(res,-1);
       int index=binarySearch(0,nums.length-1,target,nums);
       if(index==-1)
        return res;
        res[0]=index;res[1]=index;
        // recursively search in the left half
        int temp=index;
        do{
            index=binarySearch(0,index-1,target,nums);
            if(index!=-1)
                res[0]=index;
            else
                break;
        }while(true);
        index=temp;
        // recursively search in the right half
        do{
            index=binarySearch(index+1,nums.length-1,target,nums);
            if(index!=-1)
                res[1]=index;
            else
                break;
        }while(true);
        return res;
    }
    public int binarySearch(int l,int r,int ele,int[] nums){
        if(l>r)
            return -1;
        int mid=l+(r-l)/2;
        if(nums[mid]==ele)
            return mid;
        if(ele>nums[mid])
            return binarySearch(mid+1,r,ele,nums);
        return binarySearch(l,mid-1,ele,nums);
    }
}