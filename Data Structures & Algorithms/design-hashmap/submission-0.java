class MyHashMap {
    private LinkedList<Pair>[] buckets;
    private int SIZE = 1000;

    public MyHashMap() {
        buckets = new LinkedList[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        boolean toInsert = true;
        for (Pair p: buckets[index]) {
            if (p.k == key) {
                p.v = value;
                toInsert = false;
            }
        }
        if (toInsert) {
            buckets[index].add(new Pair(key, value));
        }
    }
    
    public int get(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return -1;
        }
        for (Pair p: buckets[index]) {
            if (p.k == key) {
                return p.v;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return;
        }
        Pair tmp = null;
        for (Pair p: buckets[index]) {
            if (p.k == key) {
                tmp = p;
                break;
            }
        }
        if (tmp != null) {
            buckets[index].remove(tmp);
        }
    }
}

class Pair {
    int k, v;

    public Pair(int k, int v) {
        this.k = k;
        this.v = v;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */