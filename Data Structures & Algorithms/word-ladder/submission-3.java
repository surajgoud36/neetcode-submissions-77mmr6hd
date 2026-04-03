class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        wordList.add(beginWord);
        Map<String,List<String>> patterns = new HashMap<>();
        Set<String> visit = new HashSet<>();
        for(String word:wordList){
            for(int i=0;i<word.length();i++){
                String pattern = word.substring(0,i)+"*"+word.substring(i+1);
                patterns.computeIfAbsent(pattern,k->new ArrayList<>()).add(word);
            }
        }
        int count=1;
        Queue<String> q=new ArrayDeque<>();
        q.add(beginWord);
        visit.add(beginWord);
        while(!q.isEmpty()){
            int len=q.size();
            for(int i=0;i<len;i++){
                String word=q.poll();
                if(word.equals(endWord))
                    return count;
                for(int j=0;j<word.length();j++){
                    String pattern = word.substring(0,j)+"*"+word.substring(j+1);
                    //patterns.computeIfAbsent(pattern,k->new ArrayList<>()).add(word);
                    if(patterns.containsKey(pattern)){
                        for(String w:patterns.get(pattern)){
                            if(!visit.contains(w)){
                                 q.add(w);
                                 visit.add(w);
                            }
                               
                        }
                    }
                }
                
            }
            count++;
        }
        return 0;
    }
}
