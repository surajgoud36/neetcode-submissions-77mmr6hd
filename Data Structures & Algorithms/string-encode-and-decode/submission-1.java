class Solution {

    public String encode(List<String> strs) {
        String s = "";
        for (String st : strs) {
            int len = st.length();
            s +=String.valueOf(len)+"#"+st;
        }
        return s;
    }

    public List<String> decode(String str) {
        List<String> res=new ArrayList<>();
        for(int i=0;i<str.length();i++){
            int ind=str.indexOf("#", i);
            int len=Integer.parseInt(str.substring(i, ind));
            res.add(str.substring(ind+1, ind+1+len));
            i=ind+len;
        }
        return res;
    }
}
