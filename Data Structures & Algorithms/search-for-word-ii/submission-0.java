class Solution {
    TrieNode root;
    private Set<String> res;

    public Solution(){
        root=new TrieNode();
    }
    public List<String> findWords(char[][] board, String[] words) {
        // insert words into the trie for searching effieciently 
        for(String word:words){
            this.insert(word);
        }
        int rows=board.length,cols=board[0].length;
        res=new HashSet<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                dfs(board,i,j,root,"");
            }
        }
        System.out.println(root.map);
        return new ArrayList<>(res);
    }


    public void dfs(char[][] board,int r,int c,TrieNode node,String word){
        if(r<0||c<0||r>=board.length||c>=board[0].length||!node.map.containsKey(board[r][c])||board[r][c]=='*')
            return;
        char temp=board[r][c];
        board[r][c]='*';
        TrieNode nxt=node.map.get(temp);
        word+=temp;
        if(nxt.word){
            res.add(word);
        }

        dfs(board,r,c-1,nxt,word);
        dfs(board,r,c+1,nxt,word);
        dfs(board,r+1,c,nxt,word);
        dfs(board,r-1,c,nxt,word);
        board[r][c]=temp;
    }




    public void insert(String word){
        TrieNode curr=this.root;
        for(char a:word.toCharArray()){
            if(!curr.map.containsKey(a))
                curr.map.put(a,new TrieNode());
            curr=curr.map.get(a);
        }
        curr.word=true;
    }
    // public boolean search(String word){

    // }

}
class TrieNode{
    boolean word;
    Map<Character,TrieNode> map;
    public TrieNode(){
        word=false;
        map=new HashMap<>();
    }
}