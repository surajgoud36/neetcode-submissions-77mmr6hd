class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] prev = new int[]{0,0,0};
        for(int[] t: triplets){
            if(canMerge(t,target))
                prev=merge(prev,t);
        }
        if(target[0] != prev[0] || target[1]!=prev[1] || target[2]!=prev[2])
            return false;
        return true;
    }
    public boolean canMerge(int[] t,int[] target){
        if(t[0]<=target[0] && t[1]<=target[1] && t[2]<=target[2])
            return true;
        return false;
    }
    public int[] merge(int[] t1,int[] t2){
        t1[0]=Math.max(t1[0],t2[0]);
        t1[1]=Math.max(t1[1],t2[1]);
        t1[2]=Math.max(t1[2],t2[2]);
        return t1;
    }
}
