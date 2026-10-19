class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new ArrayDeque<>();
        int original = image[sr][sc];
        if(original == color)
            return image;
        image[sr][sc] = color;
        queue.add(new int[]{sr,sc});
        
        int rows = image.length,cols = image[0].length;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] curr = queue.poll();
                int r = curr[0],c=curr[1];
               // image[r][c] = color;
                for(int[] dir: directions){
                    int nr = r+dir[0];
                    int nc = c+dir[1];
                    if(Math.min(nr,nc)<0 || nr==rows || nc==cols || image[nr][nc]!=original)
                        continue;
                    image[nr][nc] = color;
                    queue.add(new int[]{nr,nc});
                }
            }
        }
        return image;
    }
}