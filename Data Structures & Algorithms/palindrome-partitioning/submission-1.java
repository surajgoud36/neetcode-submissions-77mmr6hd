class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res=new ArrayList<>();
        dfs(new ArrayList<>(),0,s);
        return res;
    }

    public void dfs(List<String> list,int i,String s){
        if(i>=s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int j=i;j<s.length();j++){
            if(isPallindrome(i,j,s)){
                list.add(s.substring(i,j+1));
                dfs(list,j+1,s);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean isPallindrome(int i,int j,String s){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
