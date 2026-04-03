class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        for(String s:deadends){
            visited.add(s);
        }
        if(visited.contains("0000"))
            return -1;
        Queue<String> queue=new ArrayDeque<>();
        queue.add("0000");
        visited.add("0000");
        int moves=0;
        while(!queue.isEmpty()){
            int len=queue.size();

            for(int i=0;i<len;i++){
                String extracted=queue.poll();
                if(target.equals(extracted))
                    return moves;
                for(int j=0;j<4;j++){
                    int ch=extracted.charAt(j)-'0';
                    int ch1=(ch+1)%10;
                    int ch2=(ch-1+10)%10;
                    String candidate1=extracted.substring(0,j)+(char)(ch1+'0')+extracted.substring(j+1);
                    String candidate2=extracted.substring(0,j)+(char)(ch2+'0')+extracted.substring(j+1);
                    if(!visited.contains(candidate1)){
                          queue.add(candidate1);
                          visited.add(candidate1);
                    }
                      
                    if(!visited.contains(candidate2)){
                        queue.add(candidate2);
                        visited.add(candidate2);
                    }
                        
                    
                }
            }
            moves++;
        }
        return -1;
    }
}