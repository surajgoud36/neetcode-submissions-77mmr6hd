class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            twoSum(nums,i,res);
        }
        return res;
    }
    public void twoSum(int[] nums,int index,List<List<Integer>> res){
        int target = nums[index]*-1;
        //Map<Integer,Intger> map = new HashMap<>();
        int l=index+1,r=nums.length-1;
        while(l<r){
            int sum=nums[l]+nums[r];
            if(sum==target){
                res.add(new ArrayList<>(Arrays.asList(nums[index],nums[l],nums[r])));
                while(l<nums.length-2){
                    if(nums[l]==nums[l+1])
                        l++;
                    else
                        break;
                }
                l++;
                r--;
            }
            else if(sum>target)
                r--;
            else
                l++;
        }

        // Set<Integer> set = new HashSet<>();
        // Set<Integer> visit = new HashSet<>();
        // for(int i=index+1;i<nums.length;i++){
        //     int two=nums[i];
        //     if(set.contains(target-two) && !visit.contains(two)){
        //         res.add(new ArrayList<>(Arrays.asList(nums[index],target-two,two)));
        //     }
        //     visit.add(two);
        //     set.add(two);
        // }
    }
}
