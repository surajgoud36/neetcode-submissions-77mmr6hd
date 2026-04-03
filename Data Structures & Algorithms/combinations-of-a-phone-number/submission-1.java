class Solution {
    Map<Integer,String> map;
    public List<String> letterCombinations(String digits) {
        
        List<String> res=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        if(digits.length()==0)
            return res;
        map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        helper(0,digits,res,sb);
        return res;
    }

    public void helper(int ind,String digits,List<String> res,StringBuilder sb){
        if(sb.length()==digits.length()){
            res.add(sb.toString());
            return;
        }
        if(ind>=digits.length())
            return;
        char ch=digits.charAt(ind);

        String letters=map.get(ch-'0');
        for(int i=0;i<letters.length();i++){
            sb.append(letters.charAt(i));
            helper(ind+1,digits,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
