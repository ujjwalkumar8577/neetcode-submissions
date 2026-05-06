class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        ArrayList<Interval> res = new ArrayList<>();

        int i = 0;
        while (i<n && intervals[i][1] < newInterval[0]) {
            res.add(new Interval(intervals[i][0], intervals[i][1]));
            i++;
        }

        int start = newInterval[0];
        int end = newInterval[1];
        while (i<n && intervals[i][0] <= end) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        res.add(new Interval(start, end));

        while (i < n) {
            res.add(new Interval(intervals[i][0], intervals[i][1]));
            i++;
        }

        int[][] ans = new int[res.size()][2];
        for (int j = 0; j < res.size(); j++) {
            ans[j][0] = res.get(j).start;
            ans[j][1] = res.get(j).end;
        }
        return ans;
    }
}

class Interval {
    int start, end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}