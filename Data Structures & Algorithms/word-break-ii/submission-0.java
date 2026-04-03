class Solution {
    TrieNode root;
    List<String> res;
    Map<Integer,List<String>> dp;
    public List<String> wordBreak(String s, List<String> wordDict) {
        root=new TrieNode();
        res=new ArrayList<>();
        dp=new HashMap<>();
        for(String word:wordDict){
            insert(root,word);
        }
       return helper(s,0);
    }

    public List<String> helper(String s, int index){
        List<String> curr=new ArrayList<>();
        if(index>=s.length()){
            curr.add("");
            return curr;
        }
        if(dp.containsKey(index))
            return dp.get(index);
        TrieNode trieNode=root;
        for(int i=index;i<s.length();i++){
            char c=s.charAt(i);
            if(!trieNode.children.containsKey(c)){
                dp.put(index,curr);
                return curr;
            }
                
            trieNode=trieNode.children.get(c);
            // check for word and partition
            if(trieNode.word){
                // it is a word we can partition
                List<String> next=helper(s,i+1);
                if(next.size()>0){
                    // not empty, add the current partition to the remaining strings
                    for(String prev:next){
                        curr.add((s.substring(index,i+1)+" "+prev).trim());
                    }
                }
            }
        }
        dp.put(index,curr);
        return curr;
    }

    public void insert(TrieNode root,String word){
    TrieNode curr=root;
    for(char ch:word.toCharArray()){
        if(!curr.children.containsKey(ch))
            curr.children.put(ch,new TrieNode());
        curr=curr.children.get(ch);
    }
    curr.word=true;
   }
}

class TrieNode{
    boolean word;
    Map<Character,TrieNode> children;
    public TrieNode(){
        children=new HashMap<>();
        word=false;
    }
}
