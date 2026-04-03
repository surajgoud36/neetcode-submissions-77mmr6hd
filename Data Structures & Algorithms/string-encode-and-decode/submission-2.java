class Solution {

    public String encode(List<String> strs) {
        String res="";
        for(String s:strs){
            int len=s.length();
            res+=Integer.toString(len)+"#"+s;
        }
        return res;
    }

    public List<String> decode(String str) {
        List<String> list=new ArrayList<>();
        int ind=0;
        boolean status=false;
        String len="";
        //System.out.println(str);
        while(ind<str.length()){
            
                if(str.charAt(ind)=='#'){
                    int size=Integer.parseInt(len);
                    ind++;
                    list.add(str.substring(ind,ind+size));
                    ind=ind+size;
                    len="";
                }
                else{
                    len+=str.charAt(ind);
                    ind++;
                }
            
        }
        return list;
    }
}
