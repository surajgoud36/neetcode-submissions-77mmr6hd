class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] curr=null;
        for(int[] x:triplets){
            if(curr==null){
                if(determine(target,x))
                    curr=x;
            }
            else{
                if(match(target,curr,x)){
                    curr[0]=Math.max(curr[0],x[0]);
                    curr[1]=Math.max(curr[1],x[1]);
                    curr[2]=Math.max(curr[2],x[2]);
                }
            }
        }
        if(curr==null)
            return false;
        return Arrays.equals(curr,target);

    }

    public boolean match(int[] target,int[] curr,int[] next){
        // allow a swap only if all elements are less than or equal to target
        for(int i=0;i<3;i++){
            if(Math.max(curr[i],next[i])>target[i])
                return false;
        }
        return true;
    }
    public boolean determine(int[] target,int[] curr){
        for(int i=0;i<3;i++){
            if(curr[i]>target[i])
                return false;
        }
        return true;
    }
}
