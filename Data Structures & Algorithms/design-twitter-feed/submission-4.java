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
        PriorityQueue<Tweet> minHeap = new PriorityQueue<>();
        for (Integer id: userIds) {
            if (tweetMap.containsKey(id)) {
                for (Tweet tw: tweetMap.get(id)) {
                    minHeap.add(tw);
                    if (minHeap.size() > 10) {
                        minHeap.poll();
                    }
                }
            }
        }
        ArrayList<Integer> tweetIds = new ArrayList<>();
        while (minHeap.size() > 0) {
            tweetIds.add(minHeap.poll().tweetId);
        }
        Collections.reverse(tweetIds);
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
        return this.count - other.count;
    }
}
