class Solution {
    /**
     * @param {number[]} nums
     * @param {number} goal
     * @return {number}
     */
    numSubarraysWithSum(nums, goal) {
        const map = new Map();
    map.set(0,1);
    let sum=0,count=0;;
    for(const num of nums){
        sum+=num;
        if(map.has(sum-goal)){
            count+=map.get(sum-goal);
        }
        let prev=map.get(sum) ?? 0;
        map.set(sum,prev+1);
    }
    return count;
    }
}
