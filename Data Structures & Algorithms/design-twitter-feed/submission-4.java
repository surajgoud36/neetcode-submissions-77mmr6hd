class Twitter {
    Map<Integer,Set<Integer>> userMap;
    Map<Integer,List<Map.Entry<Integer,Integer>>> tweetMap;
    int counter;
    public Twitter() {
        userMap=new HashMap<>();
        tweetMap=new HashMap<>();
        counter=0;
    }
    
    public void postTweet(int userId, int tweetId) {
         if(!userMap.containsKey(userId)){
            userMap.put(userId,new HashSet<>(Arrays.asList(userId)));
        }
        counter++;
        if(!tweetMap.containsKey(userId)){
            tweetMap.put(userId,new ArrayList<>());
        }
        List<Map.Entry<Integer,Integer>> ns=tweetMap.get(userId);
        ns.add(new AbstractMap.SimpleEntry<>(counter,tweetId));
        tweetMap.put(userId,ns);

    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));
        Set<Integer> list=userMap.get(userId);
        for(int x:list){
            if(tweetMap.containsKey(x)){
                List<Map.Entry<Integer,Integer>> tl=tweetMap.get(x);
                int index=tl.size()-1;
                int[] entry={tl.get(index).getKey(),tl.get(index).getValue(),x,index-1};
                pq.add(entry);
            }
                
        }
        List<Integer> res=new ArrayList<>();
        // int size=(pq.size()>10)?10:pq.size();
        // while(size>0){
        //     res.add(pq.poll().getValue());
        //     size--;
        // }
        while(!pq.isEmpty() && res.size()<10){
            int[] node=pq.poll();
            res.add(node[1]);
            if(node[3]>=0){
                List<Map.Entry<Integer,Integer>> tl=tweetMap.get(node[2]);
                int index=node[3];
                pq.add(new int[]{tl.get(index).getKey(),tl.get(index).getValue(),node[2],index-1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        //O(1)
        if(!userMap.containsKey(followerId)){
            userMap.put(followerId,new HashSet<>(Arrays.asList(followerId)));
        }
        Set<Integer> ns=userMap.get(followerId);
        if(!ns.contains(followeeId))
            ns.add(followeeId);
        userMap.put(followerId,ns);
    }
    
    public void unfollow(int followerId, int followeeId) {
         //O(1)
         if(followerId==followeeId)
            return;
         Set<Integer> ns=userMap.get(followerId);
         ns.remove(followeeId);
        userMap.put(followerId,ns);
    }
}

class User{

    public User(){

    }
}