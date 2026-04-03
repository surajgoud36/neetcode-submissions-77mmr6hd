class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int p1=0,p2=numbers.length-1;
        int a[]=new int[2];
        while(p1<p2){
            int sum=numbers[p1]+numbers[p2];
            if(sum==target){
                
                a[0]=p1+1;
                a[1]=p2+1;
                return a;
            }
            else if(sum>target){
                p2--;
            }
            else
             p1++;
        }
        return a;
    }
}
