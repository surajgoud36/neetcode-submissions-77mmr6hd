class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res= new ArrayList<>();
        dfs(new StringBuilder(),n*2,n,0,res);
        return res;
    }
    public void dfs(StringBuilder sb,int targetLen,int n,int open,List<String> res){
        if(sb.length()==targetLen)
        {
            res.add(sb.toString());
            return;
        }
        if(open>0){
            // we can further open
            if(n>0){
                // open further
                sb.append("(");
                dfs(sb,targetLen,n-1,open+1,res);
                sb.deleteCharAt(sb.length()-1);
            }
            // close it 
            sb.append(")");
            dfs(sb,targetLen,n,open-1,res);
            sb.deleteCharAt(sb.length()-1);
        }
        else{
              if(n>0){
                // open further
                sb.append("(");
                dfs(sb,targetLen,n-1,open+1,res);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        
    }
}
