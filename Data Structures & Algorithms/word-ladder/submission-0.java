class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<>();
        for(String s:wordList){
            wordSet.add(s);
        }
        if(!wordSet.contains(endWord))
            return 0;
        if(beginWord.length()==1)
            return 2;
        wordSet.add(beginWord);
        wordList.add(beginWord);
        Map<Character,Set<Character>> incoming=new HashMap<>();
        Map<Character,Set<Character>> outgoing=new HashMap<>();
        // populate the adjacency list
        for(String s: wordList){
            for(int i=1;i<s.length();i++){
                char first=s.charAt(i-1);
                char second=s.charAt(i);
                outgoing.computeIfAbsent(first,k->new HashSet<>()).add(second);
                incoming.computeIfAbsent(second,k->new HashSet<>()).add(first);
            }
        }
        System.out.println("incomng: "+incoming);
        System.out.println("outgoing: "+outgoing);
        return bfs(beginWord,endWord,incoming,outgoing,wordSet);

    }
    public int bfs(String word,String target, Map<Character,Set<Character>> incoming, Map<Character,Set<Character>> outgoing,Set<String> wordSet){
        int count=1;
        ArrayDeque<String> q=new ArrayDeque<>();
        Set<String> visited=new HashSet<>();
        q.add(word);
        visited.add(word);
        while(!q.isEmpty()){
            int len=q.size();
            //System.out.println("Queue: "+q);
            for(int i=0;i<len;i++){
                String curr=q.poll();
                if(curr.equals(target))
                    return count;
                for(int j=0;j<curr.length();j++){
                    if(j==0){
                        // change the first word
                        for(char c:incoming.get(curr.charAt(j+1))){
                            String formed=c+curr.substring(j+1);
                            // System.out.println("first case: "+formed);
                            if(!visited.contains(formed) && wordSet.contains(formed)){
                                q.add(formed);
                                visited.add(formed);
                            }
                        }
                    }
                    else if(j==curr.length()-1){
                        //change the last word
                        for(char c:outgoing.get(curr.charAt(j-1))){
                            String formed=curr.substring(0,j)+c;
                            // System.out.println("last case: "+formed);
                            if(!visited.contains(formed) && wordSet.contains(formed)){
                                q.add(formed);
                                visited.add(formed);
                            }
                        }
                    }
                    else{
                        // change the current word 
                         for(char c:outgoing.get(curr.charAt(j-1))){
                            if(!incoming.get(curr.charAt(j+1)).contains(c))
                                continue;
                            String formed=curr.substring(0,j)+c+curr.substring(j+1);
                           // System.out.println("Middle case: "+formed);
                            if(!visited.contains(formed) && wordSet.contains(formed)){
                                q.add(formed);
                                visited.add(formed);
                            }
                        }
                    }
                }
            }
            count++;
        }
       // System.out.println(count);
        return 0;
    }
}