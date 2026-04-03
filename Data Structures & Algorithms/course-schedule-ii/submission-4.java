class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int rows=prerequisites.length;
        if(rows==0){
            int res1[] = new int[numCourses];
            Arrays.setAll(res1,i->i);
            return res1;
        }
        int cols=prerequisites[0].length;
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int[] p:prerequisites){
            map.computeIfAbsent(p[0],k->new ArrayList<>()).add(p[1]);
        }
        Set<Integer> visit = new HashSet<>();
        Set<Integer> hold = new HashSet<>();
        List<Integer> output = new ArrayList<>();
        //Deque<Integer> queue=new ArrayDeque<>();
        //int[] res=new int[numCourses];
       // int index=0;
        for(int i=0;i<numCourses;i++){
            //System.out.println(Arrays.toString(res));
            if(!visit.contains(i)){
                
                
                    if(!dfs(visit,i,output,hold,map))
                        return  new int[0];
                   
                    
                
            }
        }
        return output.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean dfs(Set<Integer> visit,int course,List<Integer> output,Set<Integer> hold, Map<Integer,List<Integer>> map){
        if(visit.contains(course))
            return true;
        if(hold.contains(course))
            return false;
        if(map.containsKey(course)){
            hold.add(course);
           for(int x:map.get(course)){
                if(!dfs(visit,x,output,hold,map))
                    return false;
           }
           hold.remove(course);
           visit.add(course);
           output.add(course);
           
            return true;
        }
        visit.add(course);
        output.add(course);
        return true;
    }
}
