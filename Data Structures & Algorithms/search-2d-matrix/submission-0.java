class Solution {
     public boolean searchMatrix(int[][] matrix, int target) {
        int ind=bsearch(matrix, target, 0, matrix.length-1);
        if(ind==-1)
            return false;
        ind=b1search(matrix, target, 0, matrix[ind].length-1, ind);
        if(ind==-1)
            return false;
        return true;
    }
    
    public int bsearch(int[][] matrix,int target,int low,int high){
        if(low>high)
            return -1;
        int mid=(low+high)/2;
        if(target>=matrix[mid][0] && target<=matrix[mid][matrix[mid].length-1])
            return mid;
        else if(target<matrix[mid][0])
            high=mid-1;
        else
            low=mid+1;
        return bsearch(matrix, target, low, high);
    }
     public int b1search(int[][] matrix,int target,int low,int high,int ind){
        if(low>high)
            return -1;
        int mid=(low+high)/2;
        if(target==matrix[ind][mid] )
            return mid;
        else if(target<matrix[ind][mid])
            high=mid-1;
        else
            low=mid+1;
        return b1search(matrix, target, low, high,ind);
    }
}
