class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int len=numCourses;
        Map<Integer,List<Integer>> map = new HashMap<>();
        Map<Integer,Set<Integer>> pre = new HashMap<>();
        for(int i=0;i<len;i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] pr: prerequisites){
            int src=pr[1];
            int dst=pr[0];
            map.computeIfAbsent(src,k->new ArrayList<>()).add(dst);
           // map.computeIfAbsent(dst,k->new ArrayList<>());
        }

        for(int i=0;i<len;i++){
            if(!pre.containsKey(i)){
                dfs(map,pre,i);
            }
        }
        List<Boolean> res = new ArrayList<>();
        int ind=0;
        for(int[] query: queries){
            int bef = query[0];
            int guy = query[1];
            if(pre.get(guy).contains(bef))
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
    public Set<Integer> dfs(Map<Integer,List<Integer>> map,Map<Integer,Set<Integer>> pre,int i){
        if(pre.containsKey(i))
            return pre.get(i);
        Set<Integer> set = new HashSet<>();
        for(int nei: map.get(i)){
            set.add(nei);
            set.addAll(dfs(map,pre,nei));
        }
        pre.put(i,set);
        return set;
    }


}