class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int queryLen=queries.length;
        List<Boolean> res=new ArrayList<>(Collections.nCopies(queryLen,false));
        int preLen=prerequisites.length;
        if(preLen==0)
            return res;
        for(int[] pre:prerequisites){
            int course=pre[1];
            int prereq=pre[0];
            map.computeIfAbsent(course,k->new ArrayList<>()).add(prereq);
        }
       // System.out.println(map);
        Map<Integer,Set<Integer>> set=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            if(!set.containsKey(i)){
                dfs(i,map,set);
            }
        }
        int i=0;
        for(int[] query:queries){
            if(set.get(query[1]).contains(query[0]))
                res.set(i,true);
            i++;
        }
        //System.out.println(set);
        return res;
    }

    public Set<Integer> dfs(int course,Map<Integer,List<Integer>> map,Map<Integer,Set<Integer>> set){
        if(set.containsKey(course)){
           // curr.addAll(set.get(course));
            return set.get(course);
        }
        if(!map.containsKey(course)){
            set.put(course,new HashSet<>());
            return set.get(course);
        }
        set.computeIfAbsent(course,k->new HashSet<>());
        Set<Integer> temp=new HashSet<>();
        for(int neigh:map.get(course)){
            //dfs(neigh,map,set,curr);
            //curr.add(neigh);
            temp.add(neigh);
            temp.addAll(dfs(neigh,map,set));
        }
        set.get(course).addAll(temp);
        return temp;
    }
}