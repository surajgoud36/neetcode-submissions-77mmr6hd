class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        List<List<Integer>> res=new ArrayList<>();
        findAns(map,new ArrayList<Integer>(),nums.length,res);
        return res;
    }
    public void findAns(Map<Integer,Integer> map,List<Integer> path,int len,List<List<Integer>> res){
        if(path.size()==len){
            res.add(new ArrayList<>(path));
            return;
        }
        Iterator<Map.Entry<Integer,Integer>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer,Integer> entry=it.next();
            if(entry.getValue()>0){
                path.add(entry.getKey());
                map.put(entry.getKey(),entry.getValue()-1);
                findAns(map,path,len,res);
                map.put(entry.getKey(),entry.getValue()+1);
                path.remove(path.size()-1);
            }
                

        }
    }
}