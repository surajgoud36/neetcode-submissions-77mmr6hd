class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            if(!curr.children.containsKey(c))
                curr.children.put(c,new TrieNode());
            curr=curr.children.get(c);
        }
        curr.word=true;
    }
    public boolean search(String word){
        return search1(word,root);
    }
    public boolean search1(String word,TrieNode curr) {
        // if(word.equals(""))
        //     return true;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='.'){
                for(char child:curr.children.keySet()){
                    if(search1(word.substring(i+1),curr.children.get(child)))
                        return true;
                }
                return false;
            }
            else{
                if(!curr.children.containsKey(c))
                return false;
                curr=curr.children.get(c);
            }
        }
       
        return curr.word;
    }
}
class TrieNode{
    boolean word;
    Map<Character,TrieNode> children;
    public TrieNode(){
        word=false;
        children=new HashMap<>();
    }
}