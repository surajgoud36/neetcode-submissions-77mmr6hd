class Solution {
    public long putMarbles(int[] weights, int k) {
        if(k==1)
            return 0L;
        int n=weights.length;
        List<Integer> splits = new ArrayList<>();
        for(int i=0;i<n-1;i++){
            splits.add(weights[i]+weights[i+1]);
        }
        Collections.sort(splits);
        long minScore=0,maxScore=0;
        for(int i=0;i<k-1;i++){
            minScore+=splits.get(i);
        }
        for(int i=splits.size()-k+1;i<splits.size();i++){
            maxScore+=splits.get(i);
        }
        return maxScore-minScore;
    }
}