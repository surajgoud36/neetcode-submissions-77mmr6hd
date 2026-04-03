class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> open = new ArrayDeque<>();
        Deque<Integer> star = new ArrayDeque<>();
        int index=0;
        for(char ch:s.toCharArray()){
            if(ch=='(')
                open.push(index);
            else if(ch=='*')
                star.push(index);
            else{
                if(open.isEmpty() && star.isEmpty())
                    return false;
                if(!open.isEmpty())
                    open.pop();
                else
                    star.pop();
            }
            index++;
        }
        while(!open.isEmpty()){
            if(star.isEmpty() || open.peek()>star.peek())
                return false;
            else{
                star.pop();
                open.pop();
            }

        }
        return true;
    }
}
