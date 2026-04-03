class Solution {
    public String simplifyPath(String path) {
        String[] arr=path.split("/+");
        String res="/";
        Deque<String> stack=new ArrayDeque<>();
        for(String x:arr){
            if(x.equals("")||x.equals("."))
                continue;
            if(x.equals("..") && !stack.isEmpty()){
                 stack.pop();
                 continue;
            }
            if(x.equals(".."))
                continue;
            stack.push(x);
        }
        if(stack.isEmpty())
            return "/";
        res="";
        while(!stack.isEmpty()){
            res="/"+stack.pop()+res;
        }
        //System.out.println(stack);
        return res;
    }
}