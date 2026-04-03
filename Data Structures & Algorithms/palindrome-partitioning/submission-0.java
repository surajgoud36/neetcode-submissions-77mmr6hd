class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res=new ArrayList<>();
        helper(new ArrayList<String>(),s,0,1,0);
        return res;
    }


    public void helper(List<String> list,String s,int i,int j,int count){
        if(j==s.length()+1){
            if(count==s.length() && !list.isEmpty()){
                res.add(new ArrayList<>(list));
            }
            return;
        }

        if(checkPallindrome(s.substring(i,j))){
            // if current substring is a pallindrome
            // we partition 
            list.add(s.substring(i,j));
            int tc=count;
            count+=j-i;
            int temp=i;
            i=j;
            j++;
            helper(list,s,i,j,count);

            // we dont partition
            i=temp;
            count=tc;
            //j--;
            list.remove(list.size()-1);
            helper(list,s,i,j,count);


        }
        else{
             j++;
         helper(list,s,i,j,count);

        }
       
    }

    public boolean checkPallindrome(String name){
        int i=0,j=name.length()-1;
        while(i<=j){
            if(name.charAt(i)!=name.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
