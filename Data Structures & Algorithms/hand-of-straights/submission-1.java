class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e: hand) {
            int freq = map.getOrDefault(e, 0) + 1;
            map.put(e, freq);
        }
        Arrays.sort(hand);
        for (int i=0; i<hand.length; i++) {
            if (map.getOrDefault(hand[i], 0) <= 0) {
                continue;
            }
            for (int j=hand[i]; j<hand[i]+groupSize; j++) {
                if (map.getOrDefault(j, 0) <= 0) {
                    return false;
                }
                map.put(j, map.get(j)-1);
            }
        }
        return true;
    }
}
