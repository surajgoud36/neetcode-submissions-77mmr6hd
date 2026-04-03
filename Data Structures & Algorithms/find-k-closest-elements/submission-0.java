class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(res.size()<k){
                res.add(arr[i]);
                continue;
            }
            if(Math.abs(x-res.get(0))>Math.abs(x-arr[i])||(Math.abs(x-res.get(0))==Math.abs(x-arr[i]) && arr[i]<res.get(0)))
            {
                res.remove(0);
                res.add(arr[i]);
            }
        }
        return res;
    }
}