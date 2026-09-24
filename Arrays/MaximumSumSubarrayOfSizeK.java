public class MaximumSumSubarrayOfSizeK {

    public static int maxSubArray(int[] nums, int k) {

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            windowSum += nums[right];

            // Window has reached size k
            if (right >= k - 1) {

                maxSum = Math.max(maxSum, windowSum);

                // Remove the leftmost element
                windowSum -= nums[left];

                left++;
            }
        }

        return maxSum;
    }
}