class Solution {
     public List<String> generateParenthesis(int n) {
        Set<String> fs=new HashSet<>();
        nailIt(fs, "", 0, 0,n);
        return new ArrayList<>(fs);
    }
    public void nailIt(Set<String> fs,String s,int open,int close,int n){
        if(s.length()==(2*n)&&open==close){
            fs.add(s);
            return;
        }
        if(open>n)
            return;
        if(close>open)
            return;
        nailIt(fs, s+"(", open+1, close, n);    
        nailIt(fs, s+")", open, close+1, n); 
    }

}
