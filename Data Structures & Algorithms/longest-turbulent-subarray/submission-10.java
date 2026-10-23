class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int max=0;
        int l=0,r=0;
        Boolean next=null;
        // true - increasing and false- decreasing
        for(r=0;r<arr.length-1;r++){
            if(next == null){
                if(arr[r+1]>arr[r])
                    next=true;
                else if(arr[r]>arr[r+1])
                    next = false;
                else
                    l++;
                //max=Math.max(max,r-l+1);
                continue;
            }
            else if(next && arr[r]>arr[r+1]){
                 max=Math.max(max,r-l+2);
                 next=!next;
            }
            else if(!next && arr[r]<arr[r+1]){
                max=Math.max(max,r-l+2);
                next=!next;
            }
            else{
                l=r;
                r--;
                next=null;
            }
               

        }
        max=Math.max(max,r-l+1);
        return max;
    }
}