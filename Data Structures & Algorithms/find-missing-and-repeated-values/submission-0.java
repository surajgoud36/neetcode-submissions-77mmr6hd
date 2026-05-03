class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map.put(grid[i][j],map.getOrDefault(grid[i][j],0)+1);
            }
        }
        int[] res=new int[2];
        for(int i=1;i<=(n*n);i++){
            if(!map.containsKey(i)){
                 res[1]=i;
                 continue;
            }
               
            if(map.get(i)>1)
                res[0]=i;
        }
        return res;
    }
}