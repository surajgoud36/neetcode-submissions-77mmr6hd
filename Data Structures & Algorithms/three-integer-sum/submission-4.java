class Solution {
    List<List<Integer>> arr;
    public List<List<Integer>> threeSum(int[] nums) {
        arr=new ArrayList<>();
        Arrays.sort(nums);
        Set<Integer> track=new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            if(i!=0 && nums[i]==nums[i-1])
                continue;
            twoSum(nums,i+1,(-1*nums[i]),nums[i]);
            track.add(nums[i]);
        }
        return arr;
    }

    public void twoSum(int[] nums,int start,int target,int ele){
        //List<Integer> res=new ArrayList<>();
        // Map<Integer,Integer> map=new HashMap<>();
        // for(int i=start;i<nums.length;i++){
        //      if(track.contains(nums[i]))
        //         continue;
        //     if(map.containsKey(target-nums[i])){
        //         //for(int j=0;j<map.get(target-nums[i]);j++){
        //             List<Integer> list=new ArrayList<>(Arrays.asList((-1*target),nums[i],target-nums[i]));
        //             if(!arr.contains(list))
        //                 arr.add(list);
        //        // }
        //     }
        //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        // }

        int l=start,r=nums.length-1;
        while(l<r){
            if(nums[l]+nums[r]==target){
                arr.add(new ArrayList<>(Arrays.asList(ele,nums[l],nums[r])));
                l++;
                while(l<nums.length){
                    if(nums[l]==nums[l-1])
                        l++;
                    else 
                        break;
                }
                r--;
                while(r>=start){
                    if(nums[r]==nums[r+1])
                        r--;
                    else
                        break;
                }
            }
            else if(nums[l]+nums[r]<target)
                l++;
            else
                r--;
        }

    }   
}
