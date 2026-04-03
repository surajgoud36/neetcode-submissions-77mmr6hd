class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] fs1=new int[26];
        int[] fs2=new int[26];
        if(s1.length()>s2.length())
            return false;
        
        for(char x:s1.toCharArray()){
            fs1[x-'a']++;
        }

        int k=s1.length();
        String check=s2.substring(0,k);
        for(char x:check.toCharArray()){
            fs2[x-'a']++;
        }
        if(match(fs1,fs2))
            return true;
        int l=0;
        for(int r=k;r<s2.length();r++){
            fs2[s2.charAt(l)-'a']--;
            l++;
            fs2[s2.charAt(r)-'a']++;
            if(match(fs1,fs2))
                return true;
        }
        return false;
    }
    public boolean match(int[] arr1,int[] arr2){
        for(int i=0;i<26;i++){
            if(arr1[i]!=arr2[i])
                return false;
        }
        return true;
    }
}
