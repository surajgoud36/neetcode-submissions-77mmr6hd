class Solution {
    record Pair(int ele,int index){}
    public int[] twoSum(int[] nums, int target) {
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(new Pair(nums[i],i));
        }
        Collections.sort(list,Comparator.comparingInt((Pair u)->u.ele()));
        int left=0,right=list.size()-1;
        while(left<right){
            int sum=list.get(left).ele()+list.get(right).ele();
            if(sum==target){
                int leftIndex=list.get(left).index();
                int rightIndex=list.get(right).index();
                if(leftIndex<rightIndex)
                    return new int[]{leftIndex,rightIndex};
                return new int[]{rightIndex,leftIndex};
            }
            else if(sum<target){
                left++;
            }
            else{
                right--;
            }
        }
        return new int[0];
    }
}
