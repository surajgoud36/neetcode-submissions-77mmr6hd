record Pair(int id,int timestamp){}
class Twitter {
    Map<Integer,User> map;
    int time;
    PriorityQueue<Pair> pq;
    public Twitter() {
        map=new HashMap<>();
        time=0;
        pq=new PriorityQueue<>(Comparator.comparingInt(Pair::timestamp));
    }
    
    public void postTweet(int userId, int tweetId) {
        map.computeIfAbsent(userId,k->new User()).tweets.add(new Pair(tweetId,++time));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        User user=map.get(userId);
       for(int i=user.tweets.size()-1;i>=0;i--){
            Pair p=user.tweets.get(i);
            if(pq.size()<10)
                pq.add(p);
            else{
                break;
            }
       }

        for(int userFId:user.following){
            User following = map.get(userFId);
            for(int i=following.tweets.size()-1;i>=0;i--){
                Pair p=following.tweets.get(i);
                if(pq.size()<10)
                    pq.add(p);
                else{
                    if(p.timestamp()>pq.peek().timestamp()){
                        pq.poll();
                        pq.add(p);
                    }
                    else{
                        break;
                    }
                }
            }
        }
        List<Integer> finalTweets = new ArrayList<>();
        while(!pq.isEmpty())
            finalTweets.add(pq.poll().id());
        Collections.reverse(finalTweets);
        return finalTweets;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId)
            return;
        
        User follower = map.computeIfAbsent(followerId,k->new User());
        if(!follower.following.contains(followeeId))
            follower.following.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        User follower = map.get(followerId);
        if(follower.following.contains(followeeId))
            follower.following.remove(Integer.valueOf(followeeId));
    }
}

class User{
    List<Pair> tweets;
    List<Integer> following;
    public User(){
        tweets=new ArrayList<>();
        following=new ArrayList<>();
    }
}
