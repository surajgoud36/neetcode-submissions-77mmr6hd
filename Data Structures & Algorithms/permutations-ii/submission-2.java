class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> res=new ArrayList<>();
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        List<Integer> path = new ArrayList<>();
        helper(res,path,nums.length,map);
        return res;
    }

    public void helper(List<List<Integer>> res,List<Integer> path,int len,Map<Integer,Integer> map){
        if(path.size()==len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>0){
                path.add(entry.getKey());
                map.put(entry.getKey(),entry.getValue()-1);
                helper(res,path,len,map);
                path.remove(path.size()-1);
                map.put(entry.getKey(),entry.getValue()+1);
            }
        }
    }
}