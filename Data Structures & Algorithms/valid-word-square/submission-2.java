class Solution {
    public boolean validWordSquare(List<String> words) {
        List<String> cols= new ArrayList<>();
        int wordLength=words.get(0).length();
        for(String word:words){
            wordLength=Math.max(wordLength,word.length());
        }
        if(wordLength!=words.size())
            return false;
        
        char[][] arr = new char[words.size()][wordLength];
        int r=0;
        for(String word: words){
            
            for(int i=0;i<word.length();i++){
                arr[r][i]=word.charAt(i);
            }
            r++;
        }
        for(int i=0;i<words.size();i++){
            for(int j=0;j<wordLength;j++){
                if(arr[i][j]!=arr[j][i])
                    return false;
            }
        }
        return true;
    }
}
