class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int reqLen = s1.length();
        // freq of characters in s1
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < reqLen; i++) {
            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int l = 0;
         Map<Character, Integer> map1 = new HashMap<>();
        for (int r = 0; r < s2.length(); r++) {
            // check if current character is present in the string and its frequency is also
            // in limits, then we can accept it and increase the window or else we try to
            // reduce the size of the window from the begining, as we know we can go this
            // far and we cannot increase it further with the starting characters seen so
            // far, so we remove character one by one from the begining and then check if
            // the new character can be added or not
            char ch=s2.charAt(r);
            if(!map.containsKey(ch))// ch not present in the original string
            {
                for(int i=l;i<r;i++){
                    map1.put(s2.charAt(i),map1.get(s2.charAt(i))-1);
                }
                l=r+1;

            }
            else{
                // ch is part of the s1, should also check frequency
                map1.put(ch,map1.getOrDefault(ch, 0)+1);
                while(map1.get(ch)>map.get(ch))// freq is more, we try to reduce the window size to include it
                {
                    map1.put(s2.charAt(l),map1.get(s2.charAt(l))-1);
                    l++;
                }
                // compare both the maps
                if(map.equals(map1))
                    return true;
            }
        }
        return false;
    }
}
