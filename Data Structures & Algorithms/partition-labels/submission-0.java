class Solution {
    public List<Integer> partitionLabels(String s) {
         Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }

        List<Integer> res=new ArrayList<>();
        int low=0,high=0;
        while(low<s.length()&&high<s.length()){
            high=map.get(s.charAt(low));
            for(int i=low;i<=high;i++){
                high=Math.max(high,map.get(s.charAt(i)));
            }
            res.add(high-low+1);
            low=high+1;
        }
        return res;
    }
}
