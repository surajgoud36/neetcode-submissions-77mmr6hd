class Solution {
    public int maxTurbulenceSize(int[] arr) {
        Boolean trend=null;
        int len=arr.length;
        if(len==1)
            return 1;
        int max=1,curr=1;
        for(int i=1;i<len;i++){
            if(arr[i]==arr[i-1])
                curr=1;
            else if(arr[i]>arr[i-1]){
                if(trend==null || trend==true){
                    curr++;
                    max=Math.max(max,curr);
                    trend=false;
                }
                else{
                    curr=1;
                    i--;
                    trend=null;
                }
            }
            else{
                if(trend==null || trend==false){
                    curr++;
                    max=Math.max(max,curr);
                    trend=true;
                }
                else{
                    curr=1;
                    i--;
                    trend=null;
                }
            }
        }
        return max;
    }
}