class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res=new ArrayList<>();
        helper(candidates,target,0,new ArrayList<Integer>(),0);
        return res;
    }

    public void helper(int[] arr,int target,int sum,List<Integer> list,int i){
       
        if(sum>target)
            return;
        if(sum==target){
            res.add(new ArrayList<>(list));
            return;
        }
         if(i>=arr.length)
            return;
        for(int j=i;j<arr.length;j++){
            sum+=arr[j];
            list.add(arr[j]);
            helper(arr,target,sum,list,j+1);
            sum-=arr[j];
            list.remove(list.size()-1);
            while(j!=arr.length-1 && arr[j]==arr[j+1])
                j++;
        }
    }
}
