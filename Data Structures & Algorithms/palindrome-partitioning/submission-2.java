class Solution {
    List<List<String>> res;
    Map<Integer,List<List<String>>> dp;
    public List<List<String>> partition(String s) {
        res=new ArrayList<>();
        List<String> path =new ArrayList<>();
        dp=new HashMap<>();
        return helper(0,s);
    }

    public List<List<String>> helper(int index,String s){
       List<List<String>> curr=new ArrayList<>();
      
        if(index>=s.length()){
            curr.add(new ArrayList<String>());
             return curr;
        }
           
        if(dp.containsKey(index))
            return dp.get(index);
        for(int i=index;i<s.length();i++){
            if(isPali(s,index,i)){
                List<List<String>> temp= helper(i+1,s);
                for(List<String> list: temp){
                    List<String> temp1=new ArrayList<>(list);
                    temp1.add(0,s.substring(index,i+1));
                    curr.add(temp1);
                }
            }
        }
        dp.put(index,curr);
        return curr;
    }

    public boolean isPali(String s, int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
