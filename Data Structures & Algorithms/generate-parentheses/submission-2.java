class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res=new ArrayList<>();
        helper(n,new StringBuilder(),n*2,0);
        return res;
    }
    public void helper(int n,StringBuilder s,int len,int open){
        if(s.length()==len){
            res.add(s.toString());
            return;
        }
        if(open>0){
            // further open when n is not equal to zero
            if(n>0){
                s.append('(');
                helper(n-1,s,len,open+1);
                s.deleteCharAt(s.length()-1);
            }
            // other option is to close it
            s.append(')');
            helper(n,s,len,open-1);
            s.deleteCharAt(s.length()-1);
        }
        else if(n>0){
            s.append('(');
            helper(n-1,s,len,open+1);
            s.deleteCharAt(s.length()-1);
        }
    }
}
