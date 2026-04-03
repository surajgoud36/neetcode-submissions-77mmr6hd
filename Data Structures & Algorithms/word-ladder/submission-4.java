class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        Map<String,List<String>> patterns = new HashMap<>();
        wordList.add(beginWord);
        for(String word:wordList){
            for(int i=0;i<word.length();i++){
                String cur=word.substring(0,i)+"*"+word.substring(i+1);
                patterns.computeIfAbsent(cur,k->new ArrayList<>()).add(word);
            }
        }
        Queue<String> queue=new ArrayDeque<>();
        Set<String> visit = new HashSet<>();
        queue.add(beginWord);
        visit.add(beginWord);
        int count=1;
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                String curr=queue.poll();
                if(curr.equals(endWord))
                    return count;
                for(int j=0;j<curr.length();j++){
                    String temp = curr.substring(0,j)+"*"+curr.substring(j+1);
                    if(patterns.containsKey(temp)){
                        for(String word:patterns.get(temp)){
                            if(!visit.contains(word)){
                                queue.add(word);
                                visit.add(word);
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
