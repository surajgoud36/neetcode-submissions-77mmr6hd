class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length==1)
            return 1;
        int low=0,high=0;
        Boolean trend=null;
        int size=Integer.MIN_VALUE;
        //true is less
        // false is more
        for(high=1;high<arr.length;high++){
            if(arr[high]<arr[high-1]){
                if(trend==null){
                    trend=true;
                    size=Math.max(size,high-low+1);
                    continue;
                }
                if(trend==false){
                    size=Math.max(size,high-low+1);
                    trend=true;
                }
                else{
                    low=high-1;
                    trend=null;
                    high--;
                }
            }
            else if(arr[high]>arr[high-1]){
                if(trend==null){
                    trend=false;
                    size=Math.max(size,high-low+1);
                    continue;
                }
                if(trend==true){
                    size=Math.max(size,high-low+1);
                    trend=false;
                }
                else{
                    low=high-1;
                    trend=null;
                    high--;
                }
            }
            else{
                low=high;
                //high--;
                trend=null;
            }
        }
        size=Math.max(size,high-low);
        return size;
    }
}