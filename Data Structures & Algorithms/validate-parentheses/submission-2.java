class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        for(char ch: s.toCharArray()){
            if(open(ch)){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty() || stack.peek()!=matching(ch))
                    return false;
                stack.pop();
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
    public boolean open(char ch){
        if(ch=='('||ch=='{'||ch=='[')
            return true;
        return false;
    }
    public Character matching(char ch){
        if(ch=='}')
            return '{';
        if(ch==']')
            return '[';
        return '(';
    }
}
