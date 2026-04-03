class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        // determine the row and then we can determine the element
        int low=0,high=rows-1;
        boolean rowcheck=false;
        int rowval=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(target>=matrix[mid][0] && target<=matrix[mid][cols-1]){
                rowval=mid;
                rowcheck=true;
                break;
            }
            else if(target<matrix[mid][0])
                high=mid-1;
            else
                low=mid+1;
        }
        if(rowcheck){
            low=0;high=cols-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(target==matrix[rowval][mid])
                    return true;
                else if(target<matrix[rowval][mid])
                    high=mid-1;
                else
                    low=mid+1;
            }
        }
        return false;
    }
}
