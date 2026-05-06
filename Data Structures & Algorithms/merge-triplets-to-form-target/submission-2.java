class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int max[] = new int[3];
        for (int[] triplet: triplets) {
            boolean isValid = true;
            for (int i=0; i<3; i++) {
                if (triplet[i] > target[i]) {
                    isValid = false;
                    break;
                }
            }
            if (!isValid) {
                continue;
            }
            for (int i=0; i<3; i++) {
                max[i] = Math.max(max[i], triplet[i]);
            }
        }
        for (int i=0; i<3; i++) {
            if (max[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}
