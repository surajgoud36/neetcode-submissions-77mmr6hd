class Solution {
    public String decodeString(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        for(char ch:s.toCharArray()){
            if(ch!=']')
                stack.push(ch);
            else{
                String temp="";
                while(stack.peek()!='['){
                    temp=stack.pop()+temp;
                }
                stack.pop();
                String numExtract="";
                while(!stack.isEmpty() && (int)stack.peek()>=48 && (int)stack.peek()<=57)
                    numExtract=stack.pop()+numExtract;
                
                int num= Integer.parseInt(numExtract);
                String next=temp;
                for(int i=0;i<num-1;i++){
                    next+=temp;
                }
                //System.out.println(next);
                for(char c:next.toCharArray())
                    stack.push(c);
                //stack.push(temp);
            }
        }
        String res="";
        while(!stack.isEmpty()){
            res=stack.pop()+res;
        }
        return res;
    }
}