class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int maxFreq=0;
        Map<Integer,Integer> count=new HashMap<>();
        for(int x:nums){
            count.put(x,count.getOrDefault(x,0)+1);
            maxFreq=Math.max(maxFreq,count.get(x));
        }
        List<Integer>[] buck=new ArrayList[maxFreq+1];
        for(int i=0;i<=maxFreq;i++){
            buck[i]=new ArrayList<>();
        }
        for(Map.Entry<Integer,Integer> entry:count.entrySet()){
            buck[entry.getValue()].add(entry.getKey());
        }
        int[] res=new int[k];
        int ind=0;
        for(int i=maxFreq;i>=0;i--){
            for(int n:buck[i]){
                res[ind++]=n;
                if(ind==k)
                    return res;
            }
        }
        return res;
    }
}
