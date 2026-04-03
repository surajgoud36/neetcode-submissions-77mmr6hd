class TrieNode{
    boolean word;
    Map<Character,TrieNode> children;
    public TrieNode(){
        word=false;
        children=new HashMap<>();
    }
}
class Trie{
    TrieNode root;
    public Trie(){
        root=new TrieNode();
    }
    public void insert(String word){
        TrieNode curr=this.root;
        for(char ch:word.toCharArray()){
            if(!curr.children.containsKey(ch)){
                curr.children.put(ch,new TrieNode());
            }
            curr=curr.children.get(ch);
        }
        curr.word=true;
    }

}
class Solution {
    TrieNode root;
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s))
            return true;
        root=new TrieNode();
        for(String word:wordDict){
            insert(word);
        }
        Boolean[] dp=new Boolean[s.length()];
        return dfs(dp,0,s);
    }
    public boolean dfs(Boolean[] dp,int index,String s){
        if(index>=s.length())
            return true;
        if(dp[index]!=null)
            return dp[index];
        TrieNode curr=root;
        for(int i=index;i<s.length();i++){
            char ch=s.charAt(i);
            if(!curr.children.containsKey(ch)){
                dp[index]=false;
                return false;
            }
            curr=curr.children.get(ch);
            if(curr.word){
                if(dfs(dp,i+1,s)){
                    dp[index]=true;
                    return true;
                }
            }
        }
        dp[index]=false;
        return false;
    }
     public void insert(String word){
        TrieNode curr=root;
        for(char ch:word.toCharArray()){
            if(!curr.children.containsKey(ch)){
                curr.children.put(ch,new TrieNode());
            }
            curr=curr.children.get(ch);
        }
        curr.word=true;
    }
}
