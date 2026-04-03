class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        List<Integer> res=new ArrayList<>();
        int index=0;
        for(char c:s.toCharArray()){
            map.put(c,index);
            index++;
        }
        int l=0,r=0,lastIndex=0;
        while(l<s.length() && r<s.length()){
            lastIndex=Math.max(lastIndex,map.get(s.charAt(r)));
            if(lastIndex==r){
                res.add(r-l+1);
                l=r+1;
                lastIndex=r+1;
            }
            r++;
        }
        return res;

    }
}
