class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1=nums1.length,len2=nums2.length;
        if(len1>len2)
            return findMedianSortedArrays(nums2,nums1);
        int len = len1 + len2;
        if(len == 0)
            return 1.0;
        int l = 0, r= len1-1, targetLen = len/2;
        while(l<=r || r==-1 ){
            int mid1 = r==-1? -1 : l + (r-l)/2;
            int mid2 = targetLen-mid1-2;
            int amax=mid1<0?Integer.MIN_VALUE:nums1[mid1];
            int amin=mid1>=len1-1?Integer.MAX_VALUE:nums1[mid1+1];
            int bmax=mid2<0?Integer.MIN_VALUE:nums2[mid2];
            int bmin=mid2>=len2-1?Integer.MAX_VALUE:nums2[mid2+1];
            // check for correct partition
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
