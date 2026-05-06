class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int e: nums) {
            sum += e;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum/k;
        int sides[] = new int[k];
        Arrays.sort(nums);
        reverse(nums);
        if (nums[nums.length - 1] > target) {
            return false;
        }
        return makesquareHelper(nums, sides, 0, sum, target);
    }

    public boolean makesquareHelper(int[] nums, int[] sides, int i, int sum, int target) {
        if (i >= nums.length) {
            for (int j=1; j<sides.length; j++) {
                if (sides[j] != sides[0]) {
                    return false;
                }
            }
            return true;
        }
        boolean res = false;
        for (int j=0; j<sides.length; j++) {
            if (sides[j] + nums[i] > target) {
                continue;
            }
            if (j > 0 && sides[j] == sides[j - 1]) {
                continue;
            }
            sides[j] += nums[i];
            res = res || makesquareHelper(nums, sides, i+1, sum, target);
            if (res) {
                return true;
            }
            sides[j] -= nums[i];
            if (sides[j] == 0) {
                break;
            }
        }
        return res;
    }

    public void reverse(int nums[]) {
        int n = nums.length;
        for (int i=0; i<n/2; i++) {
            int tmp = nums[i];
            nums[i] = nums[n-i-1];
            nums[n-i-1] = tmp;
        }
    }
}