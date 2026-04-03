class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)
            return findMedianSortedArrays(nums2,nums1);
        int len = nums1.length+nums2.length;
        int len1=nums1.length,len2=nums2.length;
        int targetLen=len/2;
        if(len==0)
            return 0.0;
        //lets find the right partion in the smaller nums1 array which are part of the left half and 
        // also remaining left half elements from the larger array
        int l=0,r=nums1.length-1;
        while(l<=r || r==-1){
            int mid1=r==-1?-1:l+(r-l)/2;
            int mid2= targetLen-mid1-2;
            // a is the smaller array, b is the larger array
            int amax=mid1<0?Integer.MIN_VALUE:nums1[mid1];
            int amin=mid1>=len1-1?Integer.MAX_VALUE:nums1[mid1+1];
            int bmax=mid2<0?Integer.MIN_VALUE:nums2[mid2];
            int bmin=mid2>=len2-1?Integer.MAX_VALUE:nums2[mid2+1];

            // check for right partition
            if(amax<=bmin && bmax<=amin){
                // valid partition
                if(targetLen*2==len){
                    return (double)(Math.max(amax,bmax)+Math.min(amin,bmin))/2.0;
                }
                else{
                    return (double)Math.min(amin,bmin);
                }
            }
            else if(amax>bmin){
                r=mid1-1;
            }
            else{
                l=mid1+1;
            }
        }
        return 0.0;
        
        
    }
}
