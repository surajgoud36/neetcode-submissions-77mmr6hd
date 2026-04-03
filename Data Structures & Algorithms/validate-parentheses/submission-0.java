class Solution {
     public boolean isValid(String s) {
        ArrayDeque<Character> dq=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            // if its an opening bracket, we push into the stack
            if(ch=='('||ch=='{'||ch=='[')
                dq.push(ch);
            else{
                if(dq.isEmpty())
                    return false;
                else{
                    if(dq.peek()!=ot(ch))
                        return false;
                    else
                        dq.pop();
                }
            }

        }
        if(!dq.isEmpty())
            return false;
        return true;
    }
    public  char ot(char t){
        if(t==']')
            return '[';
        else if(t=='}')
            return '{';
        else
            return '(';
    }
}
