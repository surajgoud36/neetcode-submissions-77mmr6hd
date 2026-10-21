class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(new StringBuilder(),res,n,0,0);
        return res;
    }
    public void helper(StringBuilder cur,List<String> res,int n,int open,int curOpen){
        if(cur.length() == (2*n)){
            res.add(cur.toString());
            return;
        }
        // if you can open then open it
        if(open<n){
            cur.append('(');
            helper(cur,res,n,open+1,curOpen+1);
            cur.deleteCharAt(cur.length()-1);
        }
        // if you can close then close it
        if(curOpen>0){
            cur.append(')');
            helper(cur,res,n,open,curOpen-1);
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
