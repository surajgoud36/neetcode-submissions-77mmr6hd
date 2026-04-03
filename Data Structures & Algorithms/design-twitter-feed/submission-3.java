class Twitter {
    Map<Integer,Set<Integer>> userMap;
    Map<Integer,Set<Map.Entry<Integer,Integer>>> tweetMap;
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
            tweetMap.put(userId,new HashSet<>());
        }
        Set<Map.Entry<Integer,Integer>> ns=tweetMap.get(userId);
        ns.add(new AbstractMap.SimpleEntry<>(counter,tweetId));
        tweetMap.put(userId,ns);

    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>(Map.Entry.comparingByKey(Comparator.reverseOrder()));
        Set<Integer> list=userMap.get(userId);
        for(int x:list){
            if(tweetMap.containsKey(x))
                pq.addAll(tweetMap.get(x));
        }
        List<Integer> res=new ArrayList<>();
        int size=(pq.size()>10)?10:pq.size();
        while(size>0){
            res.add(pq.poll().getValue());
            size--;
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