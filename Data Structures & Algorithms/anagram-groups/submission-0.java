class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list=new ArrayList<>();
        // sort the string array
        Arrays.sort(strs,Comparator.comparingInt(String::length));

        // make the buckets where anagrams go to the same bucket
        list.add(new ArrayList<>(Arrays.asList(strs[0])));
        int low=0,len=strs[0].length(),high=0;
       for(int i=1;i<strs.length;i++){
            // if same length as before buckets
            if(strs[i].length()==len){
                // check if it is part of any previous buckets 
                boolean match=false;
                for(int j=low;j<=high;j++){
                    if(checkAnagram(strs[i], list.get(j).get(0))){
                        // if there is a match, add it to that bucket 
                        list.get(j).add(strs[i]);
                        match=true;
                        break;
                    }
                }
                // if there is no match, we create a new bucket out of it
                if(!match){
                    list.add(new ArrayList<>(Arrays.asList(strs[i])));
                    high++;
                }
            }
            else{
                // transition to new length with a new bucket 
                list.add(new ArrayList<>(Arrays.asList(strs[i])));
                low=high+1;
                high=low;
                len=strs[i].length();
            }
       }
       return list;
    }
    public static boolean checkAnagram(String s,String t){
        if(s.length()!=t.length())
            return false;
        Map<Character,Integer> map1=new HashMap<Character,Integer>();
        Map<Character,Integer> map2=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
            map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
        }
       
        return map1.equals(map2);
    }
}
