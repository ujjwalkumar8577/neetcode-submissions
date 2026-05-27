class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(intervals[0][0], intervals[0][1]));
        for (int i = 1; i<intervals.length; i++) {
            int lastIndex = list.size() - 1;
            int lastEndTime = list.get(lastIndex).end;
            if (lastEndTime >= intervals[i][0]) {
                list.get(lastIndex).end = Math.max(intervals[i][1], lastEndTime);
            } else {
                list.add(new Interval(intervals[i][0], intervals[i][1]));
            }
        }
        int res[][] = new int[list.size()][2];
        for(int i=0; i<list.size(); i++) {
            res[i][0] = list.get(i).start;
            res[i][1] = list.get(i).end;
        }
        return res;
    }

    class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
