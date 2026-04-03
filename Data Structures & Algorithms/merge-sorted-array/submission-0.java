class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // if(m==0){
        //     nums1=nums2;
        //     return;
        // }

        int i1=m-1,i2=n-1,last=nums1.length-1;
        while(i1>=0 && i2>=0){
            if(nums1[i1]>=nums2[i2]){
                nums1[last]=nums1[i1];
                nums1[i1]=0;
                last--;
                i1--;
            }
            else{
                nums1[last]=nums2[i2];
                last--;
                i2--;
            }
        }
        while(i2>=0){
            nums1[last--]=nums2[i2--];
        }


    }
}