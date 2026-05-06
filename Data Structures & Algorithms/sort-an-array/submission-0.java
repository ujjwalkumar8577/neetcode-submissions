class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int a[], int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        merge(a, start, mid, end);
    }

    public void merge(int a[], int start, int mid, int end) {
        int merged[] = new int[end - start + 1];
        int index1 = start;
        int index2 = mid + 1;
        int ind = 0;
        while (index1 <= mid && index2 <= end) {
            if (a[index1] <= a[index2]) {
                merged[ind++] = a[index1++];
            } else {
                merged[ind++] = a[index2++];
            }
        }
        while (index1 <= mid) {
            merged[ind++] = a[index1++];
        }
        while (index2 <= end) {
            merged[ind++] = a[index2++];
        }
        for (int i=0, j=start; i<merged.length; i++, j++) {
            a[j] = merged[i];
        }
    }
}