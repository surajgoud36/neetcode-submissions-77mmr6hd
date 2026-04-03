class Solution {
    int min,cull;
    public int[] findRedundantConnection(int[][] edges) {
        // determine the suspected node

         Map<Integer,List<Integer>> map = new HashMap<>();
         Map<List<Integer>,Integer> edgeIndex=new HashMap<>();
         int len=edges.length;
         int ind=0;
         min=0;cull=0;
        for(int[] edge:edges){
            int x=edge[0];
            int y=edge[1];
            edgeIndex.put(Arrays.asList(x,y),ind++);
            
            map.computeIfAbsent(x,k->new ArrayList<>()).add(y);
            map.computeIfAbsent(y,k->new ArrayList<>()).add(x);
        }
        int resInd= getSuspect(edges[len-1][1],new boolean[len+1],0,map,edgeIndex);
        return edges[resInd];
        // int sus=getSuspect(edges[len-1][1],new boolean[len+1],0,map,edgeIndex);
        // System.out.print(sus);
        // return new int[0];
    }

    public int getSuspect(int node,boolean[] visited,int prev,Map<Integer,List<Integer>> map,Map<List<Integer>,Integer> edgeIndex){
        visited[node]=true;
        for(int x:map.get(node)){
            if(visited[x] && x!=prev){
                int rindex=0;
                cull=x;
                if(edgeIndex.containsKey(Arrays.asList(node,x))){
                    rindex=edgeIndex.get(Arrays.asList(node,x));
                }
                else{
                     rindex=edgeIndex.get(Arrays.asList(x,node));
                }
                min=Math.max(min,rindex);
                 return min;
            }
               
            if(visited[x])
                continue;
            int sus=getSuspect(x,visited,node,map,edgeIndex);
            if(sus!=0){
                if(cull==node){
                    // going towards cull, reached cull
                    int rindex=0;
                //cull=x;
                if(edgeIndex.containsKey(Arrays.asList(node,x))){
                    rindex=edgeIndex.get(Arrays.asList(node,x));
                }
                else{
                     rindex=edgeIndex.get(Arrays.asList(x,node));
                }
                min=Math.max(min,rindex);
                cull=-1;
                 return min;
                }
                else if(cull==-1){
                    //cull over
                    return sus;
                }
                else{
                    // goind towards cull 
                    int rindex=0;
                //cull=x;
                if(edgeIndex.containsKey(Arrays.asList(node,x))){
                    rindex=edgeIndex.get(Arrays.asList(node,x));
                }
                else{
                     rindex=edgeIndex.get(Arrays.asList(x,node));
                }
                min=Math.max(min,rindex);
                 return min;
                }
                //return sus;
            }
                
            
        }
        return 0;
    }
    // public boolean cycle(boolean[] visited,int node,int prev,map){
    //     visited[node]=true;
    //     for(int x:map.get(node)){
    //         if(visited[x]&&x!=prev)
    //             return true;
    //     }
    // }
}
