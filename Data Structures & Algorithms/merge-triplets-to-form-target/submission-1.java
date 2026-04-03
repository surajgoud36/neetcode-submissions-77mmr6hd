class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] res=new int[3];
        for(int[] triplet:triplets){
            if(isMerge(target,triplet))
                merge(res,triplet);
        }
        return checkEquality(target,res);
    }

    public boolean isMerge(int[] target,int[] source){
        for(int i=0;i<3;i++){
            if(source[i]>target[i])
                return false;
        }
        return true;
    }
    public void merge(int[] curr,int src[]){
        for(int i=0;i<3;i++){
            curr[i]=Math.max(curr[i],src[i]);
        }
    }
    public boolean checkEquality(int[] target,int[] source){
        for(int i=0;i<3;i++){
            if(target[i]!=source[i])
                return false;
        }
        return true;
    }
}
