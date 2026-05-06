class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<Interval> al = new ArrayList<>();
        for (int interval[]: intervals) {
            al.add(new Interval(interval[0], interval[1]));
        }
        Collections.sort(al);
        ArrayList<Interval> res = new ArrayList<>();
        int start = al.get(0).start;
        int end = al.get(0).end;
        for (int i=1; i<al.size(); i++) {
            if (end < al.get(i).start) {
                res.add(new Interval(start, end));
                start = al.get(i).start;
                end = al.get(i).end;
            } else {
                start = Math.min(start, al.get(i).start);
                end = Math.max(end, al.get(i).end);
            }
        }
        res.add(new Interval(start, end));
        int n = res.size();
        int ans[][] = new int[n][2];
        for (int i=0; i<n; i++) {
            ans[i][0] = res.get(i).start;
            ans[i][1] = res.get(i).end;
        }
        return ans;
    }

    
}

class Interval implements Comparable<Interval> {
    int start, end;

    public Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }

    @Override
    public int compareTo(Interval i) {
        return this.start - i.start;
    }
}
