class Solution {
    public String minWindow(String s, String t) {
        int[] currFreq=new int[26];
        int[] targetFreq=new int[26];
        Map<Character,Integer> tmap=new HashMap<>();
        Map<Character,Integer> smap=new HashMap<>();
        int min=Integer.MAX_VALUE;
        String res="";
        Set<Character> set=new HashSet<>();
        for(char x:t.toCharArray()){
            
           // x=Character.toUpperCase(x);
            set.add(x);
            //targetFreq[x-'A']++;
            tmap.put(x,tmap.getOrDefault(x,0)+1);
        }
        int l=0,r=0;
        for(r=0;r<s.length();r++){
            // do we have enough
            char ch=s.charAt(r);
            if(enough(smap,tmap)){
                if((r-l)<min){
                    min=r-l;
                    res=s.substring(l,r);
                }
                //when we have enough we try to move the left pointer
                if(movePointer(smap,tmap,s.charAt(l))){
                    // we can move the pointer
                    
                    smap.put(s.charAt(l),smap.get(s.charAt(l))-1);
                    if(smap.get(s.charAt(l))==0)
                        smap.remove(s.charAt(l));
                    l++;
                    r--;
                }
                else{
                     
                    smap.put(ch,smap.getOrDefault(ch,0)+1);
                }
            }
            else{
                // not enough, expand the window
                smap.put(ch,smap.getOrDefault(ch,0)+1);
            }
        }
        while(enough(smap,tmap) && movePointer(smap,tmap,s.charAt(l))){
             smap.put(s.charAt(l),smap.get(s.charAt(l))-1);
                    if(smap.get(s.charAt(l))==0)
                        smap.remove(s.charAt(l));
                    l++;
        }
        if(enough(smap,tmap)){
                if((r-l)<min){
                    min=r-l;
                    res=s.substring(l,r);
                }
                //when we have enough we try to move the left pointer
                
        }
        return res;
    }

    public boolean enough( Map<Character,Integer> curr, Map<Character,Integer> target){
        for(Map.Entry<Character,Integer> entry:target.entrySet()){
            if(!curr.containsKey(entry.getKey()) || curr.get(entry.getKey())<entry.getValue())
                return false;
        }
        
        return true;
    }

    public boolean movePointer(Map<Character,Integer> curr, Map<Character,Integer> target,char ch){
       if(!target.containsKey(ch)||curr.get(ch)>target.get(ch))
            return true;
       
        return false;
    }
}