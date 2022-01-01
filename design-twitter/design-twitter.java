class Twitter {
    
    static int timestamp=0;
    Map<Integer,User> userMap;
    
    class Tweet{
        
        public int id;
        public int time;
        public Tweet next;
        
        public Tweet(int id){
            this.id=id;
            time=timestamp++;
            next=null;
        }
    }
    
    class User{
        public int id;
        Set<Integer> followed = new HashSet();
        public Tweet tweet_head;
        
        public User(int id){
            this.id=id;
            followed = new HashSet();
            tweet_head=null;
            followed.add(id);
        }
        
        void post_tweet(int tid){
            Tweet tweet = new Tweet(tid);
            tweet.next=tweet_head;
            tweet_head=tweet;
        }
        
        void follow(int id){
            followed.add(id);
        }
        
        void unfollow(int id){
            followed.remove(id);
        }
    }
    
    public Twitter() {
        userMap = new HashMap();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            User u = new User(userId);
            userMap.put(userId,u);
        }
        userMap.get(userId).post_tweet(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new LinkedList<>();

		if(!userMap.containsKey(userId))   return result;

		Set<Integer> users = userMap.get(userId).followed;
		PriorityQueue<Tweet> queue = new PriorityQueue<Tweet>(users.size(), (a,b)->(b.time-a.time));
		for(int user: users){
			Tweet t = userMap.get(user).tweet_head;
			if(t!=null){
				queue.add(t);
			}
		}
		int n=0;
		while(!queue.isEmpty() && n<10){
		  Tweet t = queue.poll();
		  result.add(t.id);
		  n++;
		  if(t.next!=null)
			queue.add(t.next);
		}
        
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId);
            userMap.put(followerId,u);
        }
        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userMap.put(followeeId,u);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId==followeeId)
			return;
		userMap.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */