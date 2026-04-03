record Pair(int x,int y){}
class Solution {
    public int swimInWater(int[][] grid) {
        int rows=grid.length,cols=grid[0].length;
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((n1,n2)->Integer.compare(n1[2],n2[2]));
        minHeap.add(new int[]{0,0,0});
        int[][] visited=new int[rows][cols];
        for(int[] row:visited)
            Arrays.fill(row,-1);
        while(!minHeap.isEmpty()){
            int[] curr=minHeap.poll();
            int i=curr[0],j=curr[1],w1=curr[2];
            if(visited[i][j]!=-1)
                continue;
            visited[i][j]=w1;
            int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
            for(int[] dir:directions){
                int ni=i+dir[0],nj=j+dir[1];
                if(!valid(ni,nj,rows,cols))
                    continue;
                if(visited[ni][nj]!=-1)
                    continue;
                if(w1>=grid[i][j] && w1>=grid[ni][nj])
                    minHeap.add(new int[]{ni,nj,w1});
                else{
                    int m=Math.max(grid[i][j],grid[ni][nj]);
                    minHeap.add(new int[]{ni,nj,m-w1+w1});
                }
                   
            }
        }
        return visited[rows-1][cols-1];
    }
    public boolean valid(int i,int j,int rows,int cols){
        if(i<0||i>=rows||j<0||j>=cols)
            return false;
        return true;
    }
}