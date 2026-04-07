record Pair(char ch,int index){}
class Solution {
    public String minRemoveToMakeValid(String s) {
        int len=s.length();
        StringBuilder res=new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> marker = new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }
            else if(s.charAt(i)==')'){
                if(stack.isEmpty()){
                    marker.add(i);
                }
                else{
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            marker.add(stack.pop());
        }
        for(int i=0;i<s.length();i++){
            if(!marker.contains(i))
                res.append(s.charAt(i));
        }
        return res.toString();
    }
}