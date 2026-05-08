class Solution {
    public int findCircleNum(int[][] isConnected) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        int rows=isConnected.length;
        int cols=isConnected[0].length;
        for(int i=0;i<rows;i++){
            for(int j=i+1;j<cols;j++){
                if(isConnected[i][j]==1){
                    map.computeIfAbsent(i,k->new ArrayList<>()).add(j);
                    map.computeIfAbsent(j,k->new ArrayList<>()).add(i);
                }
            }
        }
        int cc=0;
        Set<Integer> visit = new HashSet<>();
        for(int i=0;i<rows;i++){
            if(!visit.contains(i)){
                dfs(i,visit,map);
                cc++;
                
            }
        }
        return cc;
    }
    public void dfs(int i,Set<Integer> visit,Map<Integer,List<Integer>> map){
        if(visit.contains(i))
            return;
        visit.add(i);
        if(map.containsKey(i)){
            for(int nei:map.get(i)){
                dfs(nei,visit,map);
            }
        }
    }
}