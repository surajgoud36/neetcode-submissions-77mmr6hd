class Solution {
    public boolean checkValidString(String s) {
       return fromleft(s) && fromRight(s);
    }

    public boolean fromleft(String s){
         ArrayDeque<Character> stack=new ArrayDeque<>();
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i)==')'){
                if(stack.isEmpty()&&count==0)
                    return false;
                if(!stack.isEmpty()){
                    stack.pop();
                    continue;
                }
                if(count!=0){
                    count--;
                }
            }
            else{
                count++;
            }
        }
        if(!stack.isEmpty()){
            if(stack.size()>count)
                return false;
        }
        return true;
    }

    public boolean fromRight(String s){
        ArrayDeque<Character> stack=new ArrayDeque<>();
        int count=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==')'){
                stack.push(s.charAt(i));
            }
            else if(s.charAt(i)=='('){
                if(stack.isEmpty()&&count==0)
                    return false;
                if(!stack.isEmpty()){
                    stack.pop();
                    continue;
                }
                if(count!=0){
                    count--;
                }
            }
            else{
                count++;
            }
        }
        if(!stack.isEmpty()){
            if(stack.size()>count)
                return false;
        }
        return true;
    }
}
