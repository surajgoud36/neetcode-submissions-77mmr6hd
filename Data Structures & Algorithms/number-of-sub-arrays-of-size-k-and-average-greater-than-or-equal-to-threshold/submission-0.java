class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count=0;
        int sum=0;
        int t=threshold;
        int l=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        double avg=(double)sum/k;
        if(avg>=t)
            count++;
        for(int r=k;r<arr.length;r++){
            sum-=arr[l];
            l++;
            sum+=arr[r];
            avg=(double)sum/k;
            if(avg>=t)
                count++;
        }
        return count;
    }
}