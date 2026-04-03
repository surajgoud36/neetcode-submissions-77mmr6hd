class Solution {
    Map<Character,List<Character>> map;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        map=new HashMap<>();
        res=new ArrayList<>();
        if(digits.length()==0)
            return res;
        char[] digi=digits.toCharArray();
        int ch=97;
        for(int i=2;i<=9;i++){
            char c=(char)('0'+i);
            ArrayList<Character> l=new ArrayList<>();
            if(i==7||i==9){
                for(int j=1;j<=4;j++){
                    l.add((char)ch);
                    ch=ch+1;
                }
            }
            else{
                for(int j=1;j<=3;j++){
                    l.add((char)ch);
                    ch=ch+1;
                }
                   
            }
            map.put(c,l);
        }
       helper(0,digi,new StringBuilder());
       return res;
    }

    public void helper(int i,char[] digi,StringBuilder s){
       // System.out.println("i= "+i+" S= "+s);
        if(i==digi.length)
            {
                res.add(s.toString());
                return;
            }
        List<Character> list=map.get(digi[i]);
        for(int j=0;j<list.size();j++){
            s.append(list.get(j));
            helper(i+1,digi,s);
            s.deleteCharAt(s.length()-1);
        }
    }
}
