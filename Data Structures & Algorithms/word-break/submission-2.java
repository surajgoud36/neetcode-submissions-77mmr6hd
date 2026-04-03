class Solution {
    Map<Integer,Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        map=new HashMap<>();
        return helper(s,0,set);

    }

    public boolean helper(String s,int index,Set<String> set){
        
        if(index>=s.length())
            return true;
        String p="";
        for(int i=index;i<s.length();i++){
            p+=s.charAt(i);
            if(set.contains(p)){
                // we found a word
                //System.out.println(p);
                if(map.containsKey(i+1)){
                    if(map.get(i+1))
                    {
                        map.put(index,true);
                        return true;
                    }
                }
                else if(helper(s,i+1,set)){
                    map.put(i+1,true);
                    map.put(index,true);
                    return true;
                }
                else{
                    map.put(i+1,false);
                }
                   
            }
        }
        return false;
    }
}
