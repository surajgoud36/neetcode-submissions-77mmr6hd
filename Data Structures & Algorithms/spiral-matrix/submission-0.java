class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r1=0,r2=matrix.length-1,c1=0,c2=matrix[0].length-1;
        List<Integer> res=new ArrayList<>();
        while(r1<=r2 && c1<=c2){
            // go right c1 to c2 on r1
            for(int i=c1;i<=c2;i++)
                res.add(matrix[r1][i]);
            r1++;
            if(r1<=r2 == false)
                break;
            // go down r1 to r2 on c2
            for(int i=r1;i<=r2;i++)
                res.add(matrix[i][c2]);
            c2--;
            if(c1<=c2==false)
                break;
            // go left c2 to c1 on r2
            for(int i=c2;i>=c1;i--)
                res.add(matrix[r2][i]);
            r2--;
             if(r1<=r2 == false)
                break;
            // go top r2 to r1 on c1
            for(int i=r2;i>=r1;i--)
                res.add(matrix[i][c1]);
            c1++;

        }
        return res;
    }
}
