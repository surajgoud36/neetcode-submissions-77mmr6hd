class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int[] arr=people;
        Arrays.sort(arr);
        int l=0,h=arr.length-1,b=0;
        while(l<=h){
            int w=arr[l]+arr[h];
            if(w>limit){
                b++;
                h--;
            }
            else{
                b++;
                h--;
                l++;
            }
               
        }
        return b;
    }
}