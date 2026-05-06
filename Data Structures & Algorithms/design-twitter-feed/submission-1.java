class Twitter {
    int count;
    HashMap<Integer, HashSet<Integer>> followeeMap;
    HashMap<Integer, ArrayList<Tweet>> tweetMap;

    public Twitter() {
        count = 1;
        followeeMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!tweetMap.containsKey(userId)) {
            tweetMap.put(userId, new ArrayList<>());
        }
        Tweet tweet = new Tweet(count, tweetId);
        tweetMap.get(userId).add(tweet);
        count++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        HashSet<Integer> followeesSet = followeeMap.getOrDefault(userId, new HashSet<>());
        ArrayList<Integer> userIds = new ArrayList<>(followeesSet);
        userIds.add(userId);
        ArrayList<Tweet> allTweets = new ArrayList<>();
        for (Integer id: userIds) {
            if (tweetMap.containsKey(id)) {
                allTweets.addAll(tweetMap.get(id));
            }
        }
        Collections.sort(allTweets);
        ArrayList<Integer> tweetIds = new ArrayList<>();
        for (int i=0; i<10 && i<allTweets.size(); i++) {
            tweetIds.add(allTweets.get(i).tweetId);
        }
        return tweetIds;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (!followeeMap.containsKey(followerId)) {
            followeeMap.put(followerId, new HashSet<>());
        }
        followeeMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followeeMap.containsKey(followerId)) {
            followeeMap.get(followerId).remove(followeeId);
        }
    }
}

class Tweet implements Comparable<Tweet> {
    int count, tweetId;

    public Tweet(int count, int tweetId) {
        this.count = count;
        this.tweetId = tweetId;
    }

    @Override
    public int compareTo(Tweet other) {
        return other.count - this.count;
    }
}
