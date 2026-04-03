class Solution {
    public int characterReplacement(String s, int k) {
         int res = 0;
        Map<Character, Integer> map = new HashMap<>();

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            // if the window is invlaid when the new character is assumed to be added, then
            // we have to get rid of the starting character of the window as we have gone to
            // the max extent possible with it and adding any more characters wont make it
            // valid
            while ((r - l + 1) - Collections.max(map.values()) > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            // once the window is valid update the res with max window length

            res=Math.max(res,(r-l+1));
        }

        return res;
    }
}
