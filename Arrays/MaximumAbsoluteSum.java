public class MaximumAbsoluteSum {

    public static int maxAbsoluteSum(int[] nums) {

        int currentMax = 0;
        int currentMin = 0;

        int maxSum = 0;
        int minSum = 0;

        for (int num : nums) {

            currentMax = Math.max(
                num,
                currentMax + num
            );

            currentMin = Math.min(
                num,
                currentMin + num
            );

            maxSum = Math.max(maxSum, currentMax);
            minSum = Math.min(minSum, currentMin);
        }

        return Math.max(
            maxSum,
            Math.abs(minSum)
        );
    }
}