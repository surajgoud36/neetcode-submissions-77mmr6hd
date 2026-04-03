class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack=new ArrayDeque<>();
        for(String i:operations){
            if(!(i.equals("+")||i.equals("D")||i.equals("C"))){
                // integer push to stack
               // System.out.println(i);
                stack.push(Integer.parseInt(i));
            }
            else{
                if(i.equals("+")){
                    int two=stack.pop();
                    int one=stack.pop();
                    int three=two+one;
                    stack.push(one);
                    stack.push(two);
                    stack.push(three);
                }
                else if(i.equals("D")){
                    int prev=stack.peek();
                    stack.push(prev*2);
                }
                else{
                    //C
                    stack.pop();
                }
            }
        }
        int s=0;
        while(!stack.isEmpty()){
            s+=stack.pop();
        }
        return s;
    }
}