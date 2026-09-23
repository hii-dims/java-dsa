public class MinimumWindowSort {

    public static int sort(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        // Find first number out of order from left
        while (low < nums.length - 1 &&
               nums[low] <= nums[low + 1]) {
            low++;
        }

        // Already sorted
        if (low == nums.length - 1) {
            return 0;
        }

        // Find first number out of order from right
        while (high > 0 &&
               nums[high] >= nums[high - 1]) {
            high--;
        }

        // Find minimum and maximum in the window
        int subarrayMin = Integer.MAX_VALUE;
        int subarrayMax = Integer.MIN_VALUE;

        for (int i = low; i <= high; i++) {
            subarrayMin = Math.min(subarrayMin, nums[i]);
            subarrayMax = Math.max(subarrayMax, nums[i]);
        }

        // Expand low if needed
        while (low > 0 &&
               nums[low - 1] > subarrayMin) {
            low--;
        }

        // Expand high if needed
        while (high < nums.length - 1 &&
               nums[high + 1] < subarrayMax) {
            high++;
        }

        return high - low + 1;
    }
}