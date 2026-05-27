/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Interval i: intervals) {
            int s = i.start;
            int e = i.end;
            map.put(s, map.getOrDefault(s, 0) + 1);
            map.put(e, map.getOrDefault(e, 0) - 1);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        int max = 0;
        int sum = 0; 
        for (int key: keys) {
            sum += map.get(key);
            max = Math.max(max, sum);
        }
        return max;
    }
}
