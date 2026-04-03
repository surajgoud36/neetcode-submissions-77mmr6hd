class Solution {
    //Map<Integer,Integer> map;
    int p1,p2;
    public int numDecodings(String s) {
        // map=new HashMap<>();
        // for(int i=1;i<=26;i++){
        //     if(i>=1&&i<=9)
        //         map.put(i,1);
        //     else if(i>=10 && i<=26 && i%10!=0){
        //         map.put(i,2);
        //     }
        //     else{
        //         map.put(i,1);
        //     }
        // }
        p1=0;p2=0;
        String test="";
        for(int i=s.length()-1;i>=0;i--){
            test=s.charAt(i)+test;
            int res=helper(test);
            if(i==s.length()-1)
                p2=res;
            if(i==s.length()-2)
                p1=res;
            
            
        }
        if(s.length()==1)
            return p2;
        
        return p1;
    }

    public int helper(String s){
        // base case is a 2-d digit character
        if(s.charAt(0)=='0' && s.length()==1)
            return 0;
        if(s.length()==1)
            return 1;

        if(s.length()==2){
            // what is the 2-digit number
            if(s.charAt(0)=='0')
                return 0;
            if(s.charAt(1)=='0'&& s.charAt(0)-'0'>=3)
                return 0;
            int val=Integer.parseInt(s);
            if(val==10 || val==20)
                return 1;
            if(val>=1 && val<=26)
                return 2;
            
             
            
                return 1;
           // return 0;
        }
        // if(map.containsKey(Integer.parseInt(s)))
        //     return map.get(Integer.parseInt(s));

        if(s.charAt(0)=='0'){
            p2=p1;
            p1=0;
            return p1;
        }
        
        int count=p1;
        if(valid(s.substring(0,2)))
            count+=p2;
        p2=p1;
        p1=count;
       // map.put(Integer.parseInt(s),count);
       return count;

    }
    public boolean valid(String s){
        int val=Integer.parseInt(s);
        if(val>=1&&val<=26)
            return true;
        return false;
    }
}
