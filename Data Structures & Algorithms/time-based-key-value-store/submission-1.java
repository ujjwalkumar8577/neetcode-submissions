class TimeMap {
    private HashMap<String, ArrayList<Pair>> map;

    public TimeMap() {  
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        ArrayList<Pair> list = map.get(key);
        if (list.get(0).timestamp > timestamp) {
            return "";
        }
        return binarySearch(list, timestamp);
    }

    private String binarySearch(ArrayList<Pair> list, int timestamp) {
        int l = 0;
        int r = list.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int tmp = list.get(m).timestamp;
            if (tmp == timestamp) {
                return list.get(m).value;
            } else if (tmp > timestamp) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return (r >= 0) ? list.get(r).value : "";
    }
}

class Pair {
    int timestamp;
    String value;

    public Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}
