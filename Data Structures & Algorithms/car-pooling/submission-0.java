class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 0;
        for (int[] trip: trips) {
            max = Math.max(max, trip[2]);
        }
        int arr[] = new int[max+2];
        for (int[] trip: trips) {
            arr[trip[1]] += trip[0];
            arr[trip[2]] -= trip[0];
        }
        int sum = 0;
        for (int e: arr) {
            sum += e;
            if (sum > capacity) {
                return false;
            }
        }
        return true;
    }
}