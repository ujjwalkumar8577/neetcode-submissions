class Solution {
    public void sortColors(int[] nums) {
        // int count[] = new int[3];
        // for (int num: nums) {
        //     count[num]++;
        // }
        // int k = 0;
        // for (int i=0; i<3; i++) {
        //     for (int j=0; j<count[i]; j++) {
        //         nums[k++] = i;
        //     }
        // }

        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}