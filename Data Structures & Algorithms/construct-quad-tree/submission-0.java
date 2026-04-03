/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        int curr = grid[0][0];
        boolean value = curr==1?true:false;
        boolean isLeaf = checkSame(grid);
        if(isLeaf){
            return new Node(value,isLeaf);
        }
        Node root=new Node(value,isLeaf);
        int len=grid.length/2;
        root.topLeft = construct(subArray(grid,0,0,len,len));
        root.topRight = construct(subArray(grid,0,len,len,len));
        root.bottomLeft= construct(subArray(grid,len,0,len,len));
        root.bottomRight = construct(subArray(grid,len,len,len,len));
        return root;
    }
    public int[][] subArray(int[][] array,int startRow,int startCol,int numRows,int numCols){
        int [][] res= new int[numRows][numCols];
       // System.out.println("startRows = "+startRow+"StartCol= "+startCol+"numRows= "+numRows+"numCols = "+numCols);
        //System.out.println("Array len ="+array.length+"Array cols= "+array[0].length);
        int i1=0,j1=0;
        for(int i=startRow;i<(startRow+numRows);i++){
            for(int j=startCol;j<(startCol+numCols);j++){
                res[i1][j1++]=array[i][j];
            }
            i1++;
            j1=0;
        }
        return res;
    }

    public boolean checkSame(int[][] grid){
        int num=grid[0][0];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(num!=grid[i][j])
                    return false;
            }
        }
        return true;
    }
}