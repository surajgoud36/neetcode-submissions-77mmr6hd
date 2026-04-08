class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch: s.toCharArray()){
            if(ch=='('||ch=='{'||ch=='[')
                stack.push(ch);
            else{
                if(stack.isEmpty())
                    return false;
                if(stack.peek()!=getOpen(ch))
                    return false;
                stack.pop();
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
    public Character getOpen(char ch){
        if(ch==']')
            return '[';
        if(ch=='}')
            return '{';
        return '(';
    }
}
