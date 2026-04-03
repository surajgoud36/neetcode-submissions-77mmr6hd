record Pair(int r,int c){}
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        // simultaneous exploration from each of the treasure chest till the queue becomes empty
        int rows=grid.length;
        int cols=grid[0].length;
        Queue<Pair> queue=new ArrayDeque<>();
        Set<Pair> visit =  new HashSet<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==0){
                    Pair jo=new Pair(i,j);
                    queue.add(jo);
                    visit.add(jo);
                }
            }
        }
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        int len=0;
        while(!queue.isEmpty()){
            int qLen=queue.size();
            for(int i=0;i<qLen;i++){
                Pair p=queue.poll();
            //visit.add(p);
            
                
                int row=p.r();
                int col=p.c();
                if(grid[row][col]==2147483647)
                     grid[row][col]=len;
                for(int[] dir:directions){
                    int dr=row+dir[0];
                    int dc=col+dir[1];
                    if(Math.min(dr,dc)<0 || dr==rows || dc==cols || grid[dr][dc]==-1 || visit.contains(new Pair(dr,dc)))
                        continue;
                    Pair newPair=new Pair(dr,dc);
                    queue.add(newPair);
                    visit.add(newPair);
                }   
            }
            len++;
            
        }


    }
}
