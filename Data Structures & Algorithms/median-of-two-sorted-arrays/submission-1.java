class Solution {
     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length)
            return findMedianSortedArrays(nums2, nums1);
        // smaller array in nums 1
        int half = (nums1.length + nums2.length) / 2;
        int tot = nums1.length + nums2.length;
        int low = 0, high = nums1.length - 1;
        while (true) {
            int i = 0, j = 0, aleft = 0, aright = 0, bleft = 0, bright = 0;
            if (high == -1) {
                j = half - 1;
                aleft = Integer.MIN_VALUE;
                if((high+1)<nums1.length)
                    aright=nums1[0];
                else
                    aright=Integer.MAX_VALUE;
               // aright = nums1[0];
                //bleft = nums2[j];
                 if (j < 0)
                    bleft = Integer.MIN_VALUE;
                else
                    bleft = nums2[j];
                if ((j + 1) < nums2.length)
                    bright = nums2[j + 1];
                else
                    bright = Integer.MAX_VALUE;
            } else if (low == nums1.length - 1 && high == nums1.length - 1) {
                aright = Integer.MAX_VALUE;
                aleft = nums1[low];
                j = half - low - 2;
                if (j < 0)
                    bleft = Integer.MIN_VALUE;
                else
                    bleft = nums2[j];
                if ((j + 1) < nums2.length)
                    bright = nums2[j + 1];
                else
                    bright = Integer.MAX_VALUE;
            } else {
                i = (low + high) / 2;
                j = half - i - 2;
                aleft = nums1[i];
                aright = nums1[i + 1];
                if (j < 0)
                    bleft = Integer.MIN_VALUE;
                else
                    bleft = nums2[j];
                if ((j + 1) < nums2.length)
                    bright = nums2[j + 1];
                else
                    bright = Integer.MAX_VALUE;
            }

            if (aleft <= bright && bleft <= aright) {
                if (tot % 2 == 0) {
                    // even
                    int num1 = Math.max(aleft, bleft);
                    int num2 = Math.min(aright, bright);
                    return (num1 + num2) / (double) 2;
                } else {
                    return (double) Math.min(aright, bright);
                }
            } else if (aleft > bright) {
                high = i - 1;
            } else
                low = i + 1;
        }
        
    }
}
