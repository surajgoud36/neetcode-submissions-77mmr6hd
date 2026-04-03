class Solution {
    public int maxTurbulenceSize(int[] arr) {
       int max=1,curr=1;
       char prev='n';
       for(int i=0;i<arr.length-1;i++){
            // when we dont consider
            if(arr[i]==arr[i+1]){
                curr=1;
            }
            else if(arr[i]<arr[i+1]){
                if(prev=='l'){
                    curr=1;
                    i--;
                    prev='n';
                    continue;
                }
                curr++;
                max=Math.max(max,curr);
                prev='l';
            }
            else{
                if(prev=='r'){
                     curr=1;
                     i--;
                     prev='n';
                    continue;
                }
                curr++;
                max=Math.max(max,curr);
                prev='r';
            }
       }

       return max;

    }
}