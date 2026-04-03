class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orders=new int[26];
        int i=0;
        for(char ch:order.toCharArray()){
            orders[ch-'a']=i++;
        }
        for(i=1;i<words.length;i++){
            if(check(words[i-1],words[i],orders))
                return false;
        }
        return true;
    }

    public boolean check(String word1,String word2,int[] order){
        int l1=word1.length();
        int l2=word2.length();
        int i1=0,i2=0;
        while(i1<l1 && i2<l2){
            if(order[word1.charAt(i1)-'a'] == order[word2.charAt(i2)-'a']){
                 i1++;
                i2++;
                continue;
            }
            if(order[word1.charAt(i1)-'a'] > order[word2.charAt(i2)-'a']){
                System.out.println("I am jere loop");
                 return true;
            }
            else
                return false;
               
           
        }
        if(l2<l1){
            System.out.println("I am jere out loop");
              return true;
        }
          
        return false;
    }
}