class Solution {
     public String minWindow(String s, String t) {
        String res="";
        int minLen=s.length()+1;
        Map<Character,Integer> tmap=new HashMap<>();
         Map<Character,Integer> smap=new HashMap<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            tmap.put(ch,tmap.getOrDefault(ch, 0)+1);
        }

        int l=0,r=0;
        while(l<=r && l<s.length() && r<s.length()){
            char ch=s.charAt(r); // current character
            // let's add it to the frequency
            smap.put(ch,smap.getOrDefault(ch, 0)+1);
            // check for string validity
            if(validity(smap, tmap)){
                // valid
                 // try shortening the window untill its valid
                while(!tmap.containsKey(s.charAt(l)) || smap.get(s.charAt(l))>tmap.get(s.charAt(l))){
                    // remove the count of this character, increment l and thereby decreasing the size of the window

                    smap.put(s.charAt(l),smap.get(s.charAt(l))-1);
                    l++;
                }
                // update the res if you find something smaller
                if((r-l+1)<minLen){
                    res=s.substring(l, r+1);
                    minLen=r-l+1;
                }
               

            }
            r++;
        }
        return res;
    }

    public boolean validity(Map<Character,Integer> smap,Map<Character,Integer> tmap){
        for(Character ch: tmap.keySet()){
            if(!smap.containsKey(ch) || smap.get(ch)<tmap.get(ch))
                return false;
        }
        return true;
    }
}
