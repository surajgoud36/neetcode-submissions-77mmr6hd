class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<x.length;i++){
            if(map.containsKey(x[i])){
                int pastIndex=map.get(x[i]);
                if(y[i]>y[pastIndex])
                    map.put(x[i],i);
            }
            else{
                map.put(x[i],i);
            }
        }
        List<Integer> indices=new ArrayList<>(map.values());
        indices.sort(Comparator.comparingInt((Integer p)->y[Integer.valueOf(p)]).reversed());
        if(indices.size()<3)
            return -1;
        int sum=y[indices.get(0)]+y[indices.get(1)]+y[indices.get(2)];
        return sum;
    }
}