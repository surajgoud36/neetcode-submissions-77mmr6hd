class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[][] finale = new int[nums.length][2];
        int[] res=new int[2];
        for(int i=0;i<nums.length;i++){
            finale[i][0]=nums[i];
            finale[i][1]=i;
        }

        // sort the 2d array whose children are 1-day array
        Arrays.sort(finale,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        System.out.println(Arrays.deepToString(finale));
        int low=0,high=nums.length-1;
        while(low<high){
            int sum=finale[low][0]+finale[high][0];
            if(sum==target){
                res[0]=Math.min(finale[low][1],finale[high][1]);
                res[1]=Math.max(finale[low][1],finale[high][1]);
                return res;
            }
            else if(sum<target){
                low++;
            }
            else{
                high--;
            }
        }
        return res;
    }
}
